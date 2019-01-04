package com.joyxj.nio;

import java.nio.ByteBuffer;

/**
 * ByteBuffer读取和写入不同基本类型数据
 * 基本类型最后都是转换成字节而写入缓冲区的
 * @author xiaojun
 * @version 2018-12-09
 */
public class NioTest5 {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(64);

        byteBuffer.put((byte)1);
        byteBuffer.putChar('a');
        byteBuffer.putInt(10);
        byteBuffer.putShort((short)20);
        byteBuffer.putLong(30L);
        byteBuffer.putDouble(40.05);
        byteBuffer.putFloat(40.05f);

        byteBuffer.flip();
        //取的顺序要和放的顺序一致，否则会错乱，抛出异常
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getShort());
        System.out.println(byteBuffer.getLong());
        System.out.println(byteBuffer.getDouble());
        //System.out.println(byteBuffer.getDouble()); //需要按放入的顺序取，BufferUnderflowException
        System.out.println(byteBuffer.getFloat());

    }
}
