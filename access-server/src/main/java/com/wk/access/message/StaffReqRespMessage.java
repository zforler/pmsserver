package com.wk.access.message;

import com.wk.access.message.common.StaffItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class StaffReqRespMessage extends Message {
    public static int MID = 0x90;

    private int count;
    private List<StaffItem> staffItemList;

    public StaffReqRespMessage() {
        staffItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        for (int i = 0; i < count; i++) {
            staffItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            StaffItem staffItem = new StaffItem();
            staffItem.decode(byteBuf);
            staffItemList.add(staffItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(StaffItem staffItem){
        staffItemList.add(staffItem);
        count = staffItemList.size();
    }
}
