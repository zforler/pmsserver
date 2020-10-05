package com.wk.access.message;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class StaffSumReqMessage extends Message {
    public static int MID = 0x14;

    private String subId;
    private int staffNoLen;
    private String staffNo;
    private int beginTime;
    private int endTime;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(subId));
        byteBuf.writeByte(staffNoLen);
        encodeString(byteBuf, staffNo,staffNoLen);
        byteBuf.writeInt(beginTime);
        byteBuf.writeInt(endTime);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[5];
        byteBuf.readBytes(bytes);
        subId = Message.bcd2Str(bytes);

        staffNoLen = byteBuf.readByte();
        staffNo = decodeString(byteBuf,staffNoLen);
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

    public int getStaffNoLen() {
        return staffNoLen;
    }

    public void setStaffNoLen(int staffNoLen) {
        this.staffNoLen = staffNoLen;
    }

    public String getStaffNo() {
        staffNoLen = staffNo.getBytes(Charset.forName("utf-8")).length;
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }
}
