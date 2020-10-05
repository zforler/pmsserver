package com.wk.access.message.common;

import com.wk.access.message.Message;
import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class BatchItem {
    private String batchId;
    private int nameLen;
    private String batchName;


    public void encode(ByteBuf byteBuf) {
        byteBuf.writeBytes(Message.str2Bcd(batchId));
        byteBuf.writeByte(nameLen);
        Message.encodeString(byteBuf, batchName, nameLen);
    }

    public void decode(ByteBuf byteBuf) {
        byte[] bytes = new byte[4];
        byteBuf.readBytes(bytes);
        batchId = Message.bcd2Str(bytes);

        nameLen = byteBuf.readByte();

        byte[] bytes1 = new byte[nameLen];
        byteBuf.readBytes(bytes1);
        batchName = Message.bcd2Str(bytes1);
    }


    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getNameLen() {
        return nameLen;
    }

    public void setNameLen(int nameLen) {
        this.nameLen = nameLen;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
