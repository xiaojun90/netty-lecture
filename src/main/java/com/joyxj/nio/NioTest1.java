package com.joyxj.nio;

import java.nio.IntBuffer;

public class NioTest1 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10); //缓冲区，所有的读写操作都需要通过buffer
        for (int i=0;i<intBuffer.capacity();i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();  //状态反转
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
