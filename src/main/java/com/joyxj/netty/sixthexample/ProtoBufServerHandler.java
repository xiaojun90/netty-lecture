package com.joyxj.netty.sixthexample;

import com.joyxj.protobuf.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoBufServerHandler extends SimpleChannelInboundHandler<DataInfo.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DataInfo.Message message) throws Exception {

        //通过protobuf中定义不同的消息类型，方便接收客户端不同的消息类型，如这里的Student,Teacher,Course
        //如果有新的消息类型，只要扩展protobuf的message type即可
        if (message.getMessageType() == DataInfo.Message.MessageType.Student) {
            DataInfo.Student student = message.getStudent();
            System.out.println("这个student的消息");
            System.out.println(student.getName());
            System.out.println(student.getAge());
            System.out.println(student.getEmail());
        } else if (message.getMessageType() == DataInfo.Message.MessageType.Teacher) {
            DataInfo.Teacher teacher = message.getTeacher();
            System.out.println("这个teacher的消息");
            System.out.println(teacher.getName());
            System.out.println(teacher.getEmail());
        } else {
            DataInfo.Course course = message.getCourse();
            System.out.println("这个course的消息");
            System.out.println(course.getName());
            System.out.println(course.getScore());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
