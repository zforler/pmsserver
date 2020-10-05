package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class StaffReqMessage extends Message {
    public static int MID = 0x10;


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
