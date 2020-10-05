package com.wk.access.message;

import com.wk.access.message.common.ProductItem;
import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

public class ProductReqRespAckMessage extends Message {
    public static int MID = 0x05;

    private int result;
    private int reason;


    public ProductReqRespAckMessage() {

    }

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeByte(result);
        byteBuf.writeByte(reason);

    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        result = byteBuf.readByte();
        reason = byteBuf.readByte();
    }

    @Override
    public int code() {
        return MID;
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
