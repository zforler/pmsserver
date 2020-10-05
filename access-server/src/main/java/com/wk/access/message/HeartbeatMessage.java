package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class HeartbeatMessage extends Message {
    public static int MID = 0x00;

    private int timeStamp;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeInt(timeStamp);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        timeStamp = byteBuf.readInt();
    }

    @Override
    public int code() {
        return MID;
    }

}
