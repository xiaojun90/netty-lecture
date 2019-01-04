package com.joyxj.nio;

import java.nio.IntBuffer;

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10); //缓冲区，所有的读写操作都需要通过buffer
        System.out.println(intBuffer.capacity() + ":" + intBuffer.position() + ":" + intBuffer.limit());
        for (int i=0;i<6;i++) {
            intBuffer.put(i);
        }
        System.out.println(intBuffer.capacity() + ":" + intBuffer.position() + ":" + intBuffer.limit());
        intBuffer.flip();  //状态反转
        System.out.println(intBuffer.capacity() + ":" + intBuffer.position() + ":" + intBuffer.limit());
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
        intBuffer.put(6);
        System.out.println(intBuffer.capacity() + ":" + intBuffer.position() + ":" + intBuffer.limit());
    }
}
