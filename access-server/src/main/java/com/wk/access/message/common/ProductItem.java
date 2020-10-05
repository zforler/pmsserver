package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class ProductItem {
    private String prdocutionId;
    private int nameLen;
    private String productionName;


    public void encode(ByteBuf byteBuf) {
        byteBuf.writeBytes(Message.str2Bcd(prdocutionId));
        byteBuf.writeByte(nameLen);
        Message.encodeString(byteBuf, productionName, nameLen);
    }

    public void decode(ByteBuf byteBuf) {
        byte[] bytes = new byte[4];
        byteBuf.readBytes(bytes);
        prdocutionId = Message.bcd2Str(bytes);

        nameLen = byteBuf.readByte();

        byte[] bytes1 = new byte[nameLen];
        byteBuf.readBytes(bytes1);
        productionName = Message.bcd2Str(bytes1);
    }



    public String getPrdocutionId() {
        return prdocutionId;
    }

    public void setPrdocutionId(String prdocutionId) {
        this.prdocutionId = prdocutionId;
    }

    public int getNameLen() {
        return nameLen;
    }

    public void setNameLen(int nameLen) {
        this.nameLen = nameLen;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        nameLen = productionName.getBytes(Charset.forName("utf-8")).length;
        this.productionName = productionName;
    }
}
