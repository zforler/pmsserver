package com.wk.access.message;

import com.wk.access.message.common.ProductItem;
import com.wk.access.message.common.SpecItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class SpecReqRespMessage extends Message {
    public static int MID = 0x86;

    private int count;
    private List<SpecItem> specItemList;

    public SpecReqRespMessage() {
        specItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        for (int i = 0; i < count; i++) {
            specItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            SpecItem specItem = new SpecItem();
            specItem.decode(byteBuf);
            specItemList.add(specItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(SpecItem specItem){
        specItemList.add(specItem);
        count++;
    }
}
