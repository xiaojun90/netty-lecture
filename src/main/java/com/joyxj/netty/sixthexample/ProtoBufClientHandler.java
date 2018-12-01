package com.joyxj.netty.sixthexample;

import com.joyxj.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class ProtoBufClientHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Message message) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        //定义一个随机数，用于产生模拟随机的消息类型
        int randomInt = new Random().nextInt(3);
        DataInfo.Message message;
        if (randomInt == 0) {
            message = DataInfo.Message.newBuilder().setMessageType(DataInfo.Message.MessageType.Student)
                    .setStudent(DataInfo.Student.newBuilder()
                            .setName("张三")
                            .setAge(25)
                            .setEmail("838249367@qq.com").build()).build();
        } else if (randomInt == 1) {
            message = DataInfo.Message.newBuilder().setMessageType(DataInfo.Message.MessageType.Teacher)
                    .setTeacher(DataInfo.Teacher.newBuilder()
                            .setName("李四")
                            .setEmail("lisi@qq.com").build()).build();
        } else {
            message = DataInfo.Message.newBuilder().setMessageType(DataInfo.Message.MessageType.Course)
                    .setCourse(DataInfo.Course.newBuilder()
                            .setName("语文")
                            .setScore(50).build()).build();
        }
        try {
            ctx.writeAndFlush(message);
            System.out.println("==============");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
