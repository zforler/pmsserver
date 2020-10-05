package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

public class StaffResultItem {
    private int noLen;
    private String staffNo;
    public void encode(ByteBuf byteBuf) {
        byteBuf.writeByte(noLen);
        Message.encodeString(byteBuf, staffNo, noLen);

    }

    public void decode(ByteBuf byteBuf) {
        noLen = byteBuf.readByte();

        byte[] bytes = new byte[noLen];
        byteBuf.readBytes(bytes);
        staffNo = Message.bcd2Str(bytes);

    }

    public int getNoLen() {
        return noLen;
    }

    public void setNoLen(int noLen) {
        this.noLen = noLen;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }
}
