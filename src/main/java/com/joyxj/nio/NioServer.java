package com.joyxj.nio;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * nio server
 * @author xiaojun
 * @version 2018-12-15
 */
public class NioServer {

    private static Map<String,SocketChannel> socketChannelMap = new HashMap<>(); //客户端channel集合

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); //创建一个server channel
        serverSocketChannel.configureBlocking(false); //设置成非阻塞的
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress(8899)); //绑定到一个端口

        Selector selector = Selector.open(); //选择器

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);  //注册到selector,并且关注接收连接事件

        while (true) {

            int num = selector.select(); //一直阻塞，直到有兴趣的事件发生,返回一个整数，表示事件的数量
            System.out.println("事件数量:" + num);
            Set<SelectionKey> keySet = selector.selectedKeys(); //获得所有兴趣的事件列表
            for (SelectionKey selectionKey:keySet) {
                if (selectionKey.isAcceptable()) {
                    //如果是接收连接事件
                    ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel(); //因为之前关注的接收连接事件，所有肯定可以强制转换成ServerSocketChannel
                    SocketChannel client = server.accept();
                    client.configureBlocking(false);
                    String key = "【" + UUID.randomUUID().toString() + "】";
                    socketChannelMap.put(key,client); //把客户端加到集合中
                    client.register(selector,SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    //读取事件
                    SocketChannel client = (SocketChannel)selectionKey.channel();
                    //把客户端发送的消息打印到控制台
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    byteBuffer.clear();
                    int count = client.read(byteBuffer);
                    if (count > 0) {
                        byteBuffer.flip();
                        Charset charset = Charset.forName("utf-8");
                        String receivedMeg = String.valueOf(charset.decode(byteBuffer).array());
                        System.out.println(client + ":" + receivedMeg);
                        //把数据回写到所有的连接客户端
                        for(Map.Entry<String,SocketChannel> map:socketChannelMap.entrySet()) {
                            ByteBuffer buffer = ByteBuffer.allocate(512);
                            buffer.put((map.getKey() + ":" + receivedMeg).getBytes());
                            buffer.flip();
                            map.getValue().write(buffer);
                        }
                    }
                }
            }
            keySet.clear();

        }


    }
}
