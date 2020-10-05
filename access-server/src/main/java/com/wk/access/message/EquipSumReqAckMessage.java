package com.wk.access.message;

import io.netty.buffer.ByteBuf;

public class EquipSumReqAckMessage extends Message {
    public static int MID = 0x94;

    private String subId;
    private String productionId;
    private int productionCount;
    private String technologyId;
    private int technologyCount;
    private String specId;
    private int specCount;
    private String batchId;
    private int batchCount;

    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(subId));
        byteBuf.writeBytes(str2Bcd(productionId));
        byteBuf.writeInt(productionCount);
        byteBuf.writeBytes(str2Bcd(technologyId));
        byteBuf.writeInt(technologyCount);
        byteBuf.writeBytes(str2Bcd(specId));
        byteBuf.writeInt(specCount);
        byteBuf.writeBytes(str2Bcd(batchId));
        byteBuf.writeInt(batchCount);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[5];
        byteBuf.readBytes(bytes);
        subId = Message.bcd2Str(bytes);

        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        productionId = Message.bcd2Str(bytes);
        productionCount = byteBuf.readInt();

        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        technologyId = Message.bcd2Str(bytes);
        technologyCount = byteBuf.readInt();

        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        specId = Message.bcd2Str(bytes);
        specCount = byteBuf.readInt();

        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        batchId = Message.bcd2Str(bytes);
        batchCount = byteBuf.readInt();
    }

    @Override
    public int code() {
        return MID;
    }


    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public int getProductionCount() {
        return productionCount;
    }

    public void setProductionCount(int productionCount) {
        this.productionCount = productionCount;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public int getTechnologyCount() {
        return technologyCount;
    }

    public void setTechnologyCount(int technologyCount) {
        this.technologyCount = technologyCount;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public int getSpecCount() {
        return specCount;
    }

    public void setSpecCount(int specCount) {
        this.specCount = specCount;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }
}
