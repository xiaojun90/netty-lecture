package com.joyxj.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio系列：从文件中读取数据到缓冲区
 */
public class NioTest2 {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream("NioText2.txt");
        FileChannel channel = inputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
     }
}
