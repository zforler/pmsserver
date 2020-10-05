package com.wk.access.message;

import com.wk.access.message.common.BatchItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class BatchReqRespMessage extends Message {
    public static int MID = 0x95;

    private int count;
    private List<BatchItem> batchItemList;

    public BatchReqRespMessage() {
        batchItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        for (int i = 0; i < count; i++) {
            batchItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            BatchItem batchItem = new BatchItem();
            batchItem.decode(byteBuf);
            batchItemList.add(batchItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(BatchItem batchItem){
        batchItemList.add(batchItem);
        count++;
    }
}
