package com.joyxj.netty.sixthexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * ProtoBuf序列化和反序化客户端
 */
public class ProtoBufClient {

    public static void main(String[] args) {

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.DEBUG))
                    .handler(new ProtoBufClientInitializer());
            ChannelFuture channelFuture = bootstrap.connect("localhost",8899).sync();
            System.out.println("已连接服务器端...");
            channelFuture.channel().closeFuture().sync();
        }   catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            eventLoopGroup.shutdownGracefully();
        }

    }
}
