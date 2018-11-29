package com.joyxj.netty.fouthexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyServerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeLine = ch.pipeline();
        pipeLine.addLast(new IdleStateHandler(0,0,60, TimeUnit.SECONDS));
        pipeLine.addLast(new HeartbeatHandler());
    }
}
