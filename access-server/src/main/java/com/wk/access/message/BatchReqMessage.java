package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class BatchReqMessage extends Message {
    public static int MID = 0x15;


    @Override
    public void encode0(ByteBuf byteBuf) {

    }

    @Override
    public void decode0(ByteBuf byteBuf) {

    }

    @Override
    public int code() {
        return MID;
    }

}
