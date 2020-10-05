package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class LoginAckMessage extends Message {
    public static int MID = 0x82;

    private int result;
    private int reason;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        result = byteBuf.readByte();
        reason = byteBuf.readByte();
    }

    @Override
    public int code() {
        return MID;
    }


    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getReason() {
        return reason;
    }

    public void setReason(int reason) {
        this.reason = reason;
    }
}
