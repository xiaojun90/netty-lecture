package com.joyxj.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO系统： 把数据写到文件中去。
 */
public class NioTest3 {

    public static void main(String[] args) throws Exception{
        FileOutputStream outputStream = new FileOutputStream("NioTest3.txt");
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byte[] b = "Hello World nio!".getBytes();
        byteBuffer.put(b);
        byteBuffer.flip();
        FileChannel channel = outputStream.getChannel();
        channel.write(byteBuffer);
        channel.close();
        outputStream.close();

    }


}
