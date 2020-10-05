package com.wk.access.message;

import com.wk.access.message.common.ProductItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class ProductReqRespMessage extends Message {
    public static int MID = 0x84;

    private int count;
    private List<ProductItem> productItemList;

    public ProductReqRespMessage() {
        productItemList = new ArrayList<>();
    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(count);
        for (int i = 0; i < count; i++) {
            productItemList.get(i).encode(byteBuf);
        }
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        count = byteBuf.readByte();
        for (int i = 0; i < count; i++) {
            ProductItem productItem = new ProductItem();
            productItem.decode(byteBuf);
            productItemList.add(productItem);
        }
    }

    @Override
    public int code() {
        return MID;
    }

    public void addItem(ProductItem productItem){
        productItemList.add(productItem);
        count++;
    }
}
