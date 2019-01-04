package com.joyxj.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * 关于Buffer的Scattering与Gathering
 */
public class NioTest11 {

    public static void main(String[] args) throws  Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        InetSocketAddress socketAddress = new InetSocketAddress(8899);

        serverSocketChannel.bind(socketAddress);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];
        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel channel = serverSocketChannel.accept(); //阻塞，直到有连接

        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long r = channel.read(buffers);
                byteRead += r;
                System.out.println("byteRead:" + byteRead);
                Arrays.asList(buffers).stream().map(buffer -> "position:" + buffer.position() + ",limit:" + buffer.limit())
                        .forEach(System.out::println);
            }
            int byteWrite = 0 ;
            while (byteWrite < messageLength) {
                long w = channel.write(buffers);
                byteWrite +=w;
            }
            Arrays.asList(buffers).forEach(byteBuffer -> byteBuffer.flip());
        }



    }
}
