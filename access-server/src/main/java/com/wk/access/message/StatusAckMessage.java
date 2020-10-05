package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class StatusAckMessage extends Message {
    public static int MID = 0x93;

    private int msgIndex;
    private int result;
    private int reason;


    public StatusAckMessage() {

    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeInt(msgIndex);
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);

    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        msgIndex = byteBuf.readInt();
        result = byteBuf.readByte();
        reason = byteBuf.readByte();
    }

    @Override
    public int code() {
        return MID;
    }

    public int getMsgIndex() {
        return msgIndex;
    }

    public void setMsgIndex(int msgIndex) {
        this.msgIndex = msgIndex;
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
