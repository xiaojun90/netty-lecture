package com.joyxj.netty.seventhexample;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;

/**
 * 客户端的心跳
 * @author xiaojun
 * @version 2019/1/7
 */
public class ClientHeatHandler extends ChannelInboundHandlerAdapter {

    private static final ByteBuf HEART_BEAT_SEQUENCE = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("HEARTBEAT", CharsetUtil.UTF_8));

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent)evt;
            if (IdleState.READER_IDLE == event.state()) {
                //超时未读到信息,关闭连接
                //ctx.close();
            } else if (IdleState.WRITER_IDLE == event.state()) {
                //超时未写信息，判断心跳信息
                System.out.println("自动发送心跳信息");
                ctx.channel().writeAndFlush(HEART_BEAT_SEQUENCE);
            }

        }
    }
}
