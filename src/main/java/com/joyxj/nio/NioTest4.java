package com.joyxj.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO的基本读写：从一个文件中读取到另外一个文件中
 */
public class NioTest4 {

    public static void main(String[] args) throws Exception{

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileChannel inputChannel = inputStream.getChannel(); //input的通道

        FileOutputStream outputStream = new FileOutputStream("out.txt");

        FileChannel outChannel = outputStream.getChannel(); //output的通道

        ByteBuffer byteBuffer = ByteBuffer.allocate(20);  //定义一个容量为20的缓冲区
        while (true) {
            // 清空操作。实际上并不是清空了缓冲区，而是把ByteBuffer设置为了初始的状态。把position=0
            // limit设置为capacity，capacity为缓冲区的大小。
            //如果不执行clear操作的话，在执行flip操作后，limit=position，position=0,
            // 然后在执行write操作后，会使得position=limit，此时将无法再往byteBuffer中写数据
            byteBuffer.clear();
            //把文件中的数据读到缓冲区中,read的大小为读取到缓冲区的大小。
            //如果channel中的数据大于缓冲区的大小，则每次读取缓冲区大小的数据，否则就读取实际的大小
            //如果没有数据可以读取时，read的返回值为-1
            //如果无法往缓冲区读取数据时(即Buffer的position的值等于limit值时,此时无法往缓冲区读取数据)，返回值为0
            int read = inputChannel.read(byteBuffer);
            if (read == -1) {
                //表示没有数据可以读取到缓冲区
                break;
            }
            byteBuffer.flip(); //翻转,翻转后，limit=position,position=-1

            //把缓冲区的数据写到输出通道中，此时position = limit
            outChannel.write(byteBuffer);
        }
    }
}
