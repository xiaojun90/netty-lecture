package com.joyxj.nio;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class NioClient {

    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        byteBuffer.put("张三".getBytes());
        Charset charset = Charset.forName("utf-8");
        byteBuffer.flip();
        System.out.println(String.valueOf(charset.decode(byteBuffer).array()));
    }
}
