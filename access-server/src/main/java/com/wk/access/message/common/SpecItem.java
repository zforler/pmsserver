package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class SpecItem {
    private String specId;
    private int nameLen;
    private String specName;
    private String prdocutionId;

    public void encode(ByteBuf byteBuf) {
        byteBuf.writeBytes(Message.str2Bcd(specId));
        byteBuf.writeByte(nameLen);
        Message.encodeString(byteBuf, specName, nameLen);
        byteBuf.writeBytes(Message.str2Bcd(prdocutionId));
    }

    public void decode(ByteBuf byteBuf) {
        byte[] bytes = new byte[4];
        byteBuf.readBytes(bytes);
        specId = Message.bcd2Str(bytes);

        nameLen = byteBuf.readByte();

        byte[] bytes1 = new byte[nameLen];
        byteBuf.readBytes(bytes1);
        specName = Message.bcd2Str(bytes1);

        byte[] bytes2 = new byte[4];
        byteBuf.readBytes(bytes2);
        prdocutionId = Message.bcd2Str(bytes2);
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

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        nameLen = specName.getBytes(Charset.forName("utf-8")).length;
        this.specName = specName;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }
}
