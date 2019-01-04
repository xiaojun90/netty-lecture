package com.joyxj.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * selector使用
 * @author xiaojun
 * @version 2018-12-14
 */
public class NioTest12 {

    public static void main(String[] args) throws IOException {
        int[] ports = new int[]{5001,5002,5003,5004,5005};

        Selector selector = Selector.open(); //创建一个selector

        for (int port : ports) {
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            socketChannel.configureBlocking(false); //设置通道为非阻塞的方式
            InetSocketAddress socketAddress = new InetSocketAddress(port);
            ServerSocket serverSocket = socketChannel.socket();
            serverSocket.bind(socketAddress);
            socketChannel.register(selector, SelectionKey.OP_ACCEPT);  //把通道注册到selector,并且关注接收的事件
            System.out.println("监听端口:" + port);
        }

        while (true) {
            int number = selector.select();
            System.out.println("数量:" + number);
            Set<SelectionKey> selectionKeySet = selector.selectedKeys(); //获得接收到事件列表
            Iterator<SelectionKey> iterator = selectionKeySet.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel(); //根据SelectKey获得通道
                    SocketChannel socketChannel = serverSocketChannel.accept(); //客户端连接
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector,SelectionKey.OP_READ); //真正的注册 ,并且关注读取事件
                    System.out.println(socketChannel);
                    iterator.remove(); //消费完后删除事件
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    int byteRead = 0;
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(512);
                        byteBuffer.clear();
                        int num = socketChannel.read(byteBuffer);
                        if (num <= 0) {
                            break;
                        }
                        byteBuffer.flip();
                        socketChannel.write(byteBuffer);
                        byteRead +=num;
                    }
                    System.out.println("从客户端读取字节数:" + byteRead);
                    iterator.remove(); //消费完后删除事件
                }
             }

        }
    }
}
