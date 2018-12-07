package com.joyxj.netty.fifthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;

/**
 * @author: xiaojun
 * @version: 2018/12/7
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame msg) throws Exception {

        if (msg instanceof TextWebSocketFrame) {
            TextWebSocketFrame textWebSocketFrame = (TextWebSocketFrame)msg;
            String text = textWebSocketFrame.text();
            System.out.println(textWebSocketFrame.text());
            ctx.channel().writeAndFlush(new TextWebSocketFrame(text.toUpperCase()));
        }
    }
}
