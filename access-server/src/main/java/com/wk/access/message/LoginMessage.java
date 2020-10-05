package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class LoginMessage extends Message {
    public static int MID = 0x02;

    private String softVersion;
    private int equipmentType;
    private String seq;
    private int subCount;

    @Override
    public void encode0(ByteBuf byteBuf) {
        encodeString(byteBuf, softVersion, 10);
        byteBuf.writeByte(equipmentType);
        encodeString(byteBuf, seq, 32);
        byteBuf.writeByte(subCount);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        softVersion = decodeString(byteBuf,10);
        equipmentType = byteBuf.readByte();
        seq = decodeString(byteBuf,32);
        subCount = byteBuf.readByte();
    }

    @Override
    public int code() {
        return MID;
    }

    public String getSoftVersion() {
        return softVersion;
    }

    public void setSoftVersion(String softVersion) {
        this.softVersion = softVersion;
    }

    public int getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(int equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public int getSubCount() {
        return subCount;
    }

    public void setSubCount(int subCount) {
        this.subCount = subCount;
    }
}
