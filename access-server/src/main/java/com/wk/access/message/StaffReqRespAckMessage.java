package com.wk.access.message;

import com.wk.access.message.common.StaffResultItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class StaffReqRespAckMessage extends Message {
    public static int MID = 0x11;
    private int count;
    private List<StaffResultItem> staffResultItemList;
    private int result;
    private int reason;


    public StaffReqRespAckMessage() {
        staffResultItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);
        for (int i = 0; i < count; i++) {
            staffResultItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        result = byteBuf.readByte();
        reason = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            StaffResultItem staffResultItem = new StaffResultItem();
            staffResultItem.decode(byteBuf);
            staffResultItemList.add(staffResultItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(StaffResultItem staffResultItem){
        staffResultItemList.add(staffResultItem);
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
