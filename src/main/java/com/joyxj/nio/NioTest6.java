package com.joyxj.nio;

import java.nio.IntBuffer;

/**
 * slice操作：切分操作，从原来的buffer中切分部分内容。
 * 其内容从原来的buffer的position开始，其capacity为原来buffer的limit,position设置为0
 *
 * 注意：slice的buffer与原来的buffer的数据是共享的。也就是改变其中一个buffer，也会改变另外一个buffer
 */
public class NioTest6 {

    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(10);

        for (int i=0;i<intBuffer.capacity();i++) {
            intBuffer.put(i);
        }

        intBuffer.position(2);
        intBuffer.limit(6);

        //
        IntBuffer newBuffer = intBuffer.slice();
        while (newBuffer.hasRemaining()) {
            System.out.println(newBuffer.get());
        }

        newBuffer.clear();

        for (int i=0;i<newBuffer.capacity();i++) {
            newBuffer.put(i*2);
        }

        intBuffer.position(0);
        intBuffer.limit(intBuffer.capacity());

        System.out.println("====================");
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
