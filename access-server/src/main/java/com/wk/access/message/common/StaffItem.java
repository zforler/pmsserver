package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class StaffItem {
    private int noLen;
    private String staffNo;
    private int nameLen;
    private String staffName;
    private int cardCount;
    private List<String> cardNoList;
    private int op;

    public StaffItem() {
        cardNoList = new ArrayList<>();
    }

    public void encode(ByteBuf byteBuf) {
        byteBuf.writeByte(noLen);
        Message.encodeString(byteBuf, staffNo, noLen);
        byteBuf.writeByte(nameLen);
        Message.encodeString(byteBuf, staffName, nameLen);
        byteBuf.writeByte(cardCount);
        for (int i = 0; i < cardCount; i++) {
            Message.encodeString(byteBuf, cardNoList.get(i), 8);
        }
        byteBuf.writeByte(op);
    }

    public void decode(ByteBuf byteBuf) {
        noLen = byteBuf.readByte();

        byte[] bytes = new byte[noLen];
        byteBuf.readBytes(bytes);
        staffNo = Message.bcd2Str(bytes);

        nameLen = byteBuf.readByte();

        byte[] bytes1 = new byte[nameLen];
        byteBuf.readBytes(bytes1);
        staffName = Message.bcd2Str(bytes1);

        cardCount = byteBuf.readUnsignedByte();
    }

    public void addCardNo(String cardNo){
        cardNoList.add(cardNo);
        cardCount = cardNoList.size();
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

    public int getNameLen() {
        return nameLen;
    }

    public void setNameLen(int nameLen) {
        this.nameLen = nameLen;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void setCardCount(int cardCount) {
        this.cardCount = cardCount;
    }

    public List<String> getCardNoList() {
        return cardNoList;
    }

    public void setCardNoList(List<String> cardNoList) {
        this.cardNoList = cardNoList;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }
}
