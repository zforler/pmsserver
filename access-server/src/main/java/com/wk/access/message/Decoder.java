package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public interface Decoder {
    public Message decode(ByteBuf buf);
}
