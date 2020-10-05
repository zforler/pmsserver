package com.wk.access.message;

import com.wk.access.message.common.TecItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class TecReqRespMessage extends Message {
    public static int MID = 0x88;

    private int count;
    private List<TecItem> tecItemList;

    public TecReqRespMessage() {
        tecItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        for (int i = 0; i < count; i++) {
            tecItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            TecItem tecItem = new TecItem();
            tecItem.decode(byteBuf);
            tecItemList.add(tecItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(TecItem tecItem){
        tecItemList.add(tecItem);
        count++;
    }
}
