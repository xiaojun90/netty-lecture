package com.joyxj.netty.seventhexample;

import io.netty.channel.ChannelHandler;

/**
 * 维护handlers集合接口
 * @author xiaojun
 * @version 2019/1/7
 */
public interface ChannelHandlerHolder {

    ChannelHandler[] handlers();
}
