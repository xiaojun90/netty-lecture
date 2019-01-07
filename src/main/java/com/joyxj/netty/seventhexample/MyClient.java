package com.joyxj.netty.seventhexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.HashedWheelTimer;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaojun
 * @version 2019/1/4
 */
public class MyClient {

    protected static final HashedWheelTimer timer = new HashedWheelTimer();

    public static void main(String[] args) throws InterruptedException {


        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        ConnectorIdleStateTrigger idleStateTrigger = new ConnectorIdleStateTrigger();

        bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).handler(new LoggingHandler(LogLevel.INFO));
        ConnectionWatch watch = new ConnectionWatch(bootstrap,timer,8899,"localhost",true) {
            @Override
            public ChannelHandler[] handlers() {
                return new ChannelHandler[] {
                        this,
                        new IdleStateHandler(0, 4, 0, TimeUnit.SECONDS),
                        new ConnectorIdleStateTrigger(),
                        new StringDecoder(),
                        new StringEncoder(),
                        new MyClientHandler()
                };
            }
        };
        ChannelFuture future;
        //进行连接
        try {
           synchronized (bootstrap) {
               bootstrap.handler(new ChannelInitializer<Channel>() {
                   @Override
                   protected void initChannel(Channel ch) throws Exception {
                        ch.pipeline().addLast(watch.handlers());
                   }
               });
               future = bootstrap.connect("localhost",8899);
           }
            future.sync();
        } catch (Exception e) {
            eventLoopGroup.shutdownGracefully();
        }


    }
}
