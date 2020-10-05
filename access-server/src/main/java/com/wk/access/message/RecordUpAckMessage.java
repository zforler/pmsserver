package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class RecordUpAckMessage extends Message {
    public static int MID = 0x92;

    private String recordId;
    private int result;
    private int reason;


    public RecordUpAckMessage() {

    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(recordId));
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);

    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[11];
        byteBuf.readBytes(bytes);
        recordId = Message.bcd2Str(bytes);
        result = byteBuf.readByte();
        reason = byteBuf.readByte();
    }

    @Override
    public int code() {
        return MID;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
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
