package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class StatusMessage extends Message {
    public static int MID = 0x13;

    private String subId;
    private int status;
    private int faultCode;
    private int faultTime;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(subId));
        byteBuf.writeByte(status);
        byteBuf.writeByte(faultCode);
        byteBuf.writeInt(faultTime);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[5];
        byteBuf.readBytes(bytes);
        subId = Message.bcd2Str(bytes);

        status = byteBuf.readByte();
        faultCode = byteBuf.readByte();
        faultTime = byteBuf.readInt();
    }

    @Override
    public int code() {
        return MID;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getFaultCode() {
        return faultCode;
    }

    public void setFaultCode(int faultCode) {
        this.faultCode = faultCode;
    }

    public int getFaultTime() {
        return faultTime;
    }

    public void setFaultTime(int faultTime) {
        this.faultTime = faultTime;
    }
}
