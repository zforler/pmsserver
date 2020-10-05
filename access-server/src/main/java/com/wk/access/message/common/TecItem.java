package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class TecItem {
    private String technologyId;
    private int nameLen;
    private String technologyName;
    private String prdocutionId;

    public void encode(ByteBuf byteBuf) {
        byteBuf.writeBytes(Message.str2Bcd(technologyId));
        byteBuf.writeByte(nameLen);
        Message.encodeString(byteBuf, technologyName, nameLen);
        byteBuf.writeBytes(Message.str2Bcd(prdocutionId));
    }

    public void decode(ByteBuf byteBuf) {
        byte[] bytes = new byte[4];
        byteBuf.readBytes(bytes);
        technologyId = Message.bcd2Str(bytes);

        nameLen = byteBuf.readByte();

        byte[] bytes1 = new byte[nameLen];
        byteBuf.readBytes(bytes1);
        technologyName = Message.bcd2Str(bytes1);

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

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        nameLen = technologyName.getBytes(Charset.forName("utf-8")).length;
        this.technologyName = technologyName;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }
}
