package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class EquipSumReqMessage extends Message {
    public static int MID = 0x17;

    private String subId;
    private int beginTime;
    private int endTime;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(subId));
        byteBuf.writeInt(beginTime);
        byteBuf.writeInt(endTime);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[5];
        byteBuf.readBytes(bytes);
        subId = Message.bcd2Str(bytes);

        beginTime = byteBuf.readInt();
        endTime = byteBuf.readInt();

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

    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
}
