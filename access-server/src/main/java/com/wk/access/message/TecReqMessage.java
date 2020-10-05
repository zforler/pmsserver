package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class TecReqMessage extends Message {
    public static int MID = 0x08;

    private String productionId;


    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(productionId));
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[4];
        byteBuf.readBytes(bytes);
        productionId = bcd2Str(bytes);
    }

    @Override
    public int code() {
        return MID;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }
}
