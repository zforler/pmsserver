package com.wk.access.message;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class SignInAckMessage extends Message {
    public static int MID = 0x99;

    private String recordId;
    private String signEquipmentId;
    private String cardNo;
    private int staffNoLen;
    private String staffNo;
    private int type;
    private int result;
    private int reason;



    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(recordId));
        byteBuf.writeBytes(str2Bcd(signEquipmentId));
        encodeString(byteBuf, cardNo,8);
        byteBuf.writeByte(staffNoLen);
        encodeString(byteBuf, staffNo,staffNoLen);
        byteBuf.writeByte(type);
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[11];
        byteBuf.readBytes(bytes);
        recordId = Message.bcd2Str(bytes);

        bytes = new byte[5];
        byteBuf.readBytes(bytes);
        signEquipmentId = Message.bcd2Str(bytes);

        cardNo = decodeString(byteBuf,8);
        staffNoLen = byteBuf.readByte();
        staffNo = decodeString(byteBuf,staffNoLen);
        type = byteBuf.readByte();
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


    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        staffNoLen = staffNo.getBytes(Charset.forName("utf-8")).length;
        this.staffNo = staffNo;
    }

    public String getSignEquipmentId() {
        return signEquipmentId;
    }

    public void setSignEquipmentId(String signEquipmentId) {
        this.signEquipmentId = signEquipmentId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getStaffNoLen() {
        return staffNoLen;
    }

    public void setStaffNoLen(int staffNoLen) {
        this.staffNoLen = staffNoLen;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
