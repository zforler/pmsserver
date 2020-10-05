package com.wk.access.message;

import io.netty.buffer.ByteBuf;

import java.nio.charset.Charset;

public class RecordUpMessage extends Message {
    public static int MID = 0x12;

    private String recordId;
    private String dispatchId;
    private String deliveryId;
    private String dispatchCardNo;
    private String deliveryCardNo;
    private int dispatchKg;
    private int deliveryKg;
    private int staffNoLen;
    private String staffNo;
    private String productionId;
    private String specId;
    private String technologyId;
    private String batchId;
    private int recordTime;



    @Override
    public void encode0(ByteBuf byteBuf) {
        byteBuf.writeBytes(str2Bcd(recordId));
        byteBuf.writeBytes(str2Bcd(dispatchId));
        byteBuf.writeBytes(str2Bcd(deliveryId));
        encodeString(byteBuf, dispatchCardNo,8);
        encodeString(byteBuf, deliveryCardNo,8);
        byteBuf.writeInt(dispatchKg);
        byteBuf.writeInt(deliveryKg);
        byteBuf.writeByte(staffNoLen);
        encodeString(byteBuf, staffNo,staffNoLen);
        byteBuf.writeBytes(str2Bcd(productionId));
        byteBuf.writeBytes(str2Bcd(specId));
        byteBuf.writeBytes(str2Bcd(technologyId));
        byteBuf.writeBytes(str2Bcd(batchId));
        byteBuf.writeInt(recordTime);
    }

    @Override
    public void decode0(ByteBuf byteBuf) {
        byte[] bytes = new byte[11];
        byteBuf.readBytes(bytes);
        recordId = Message.bcd2Str(bytes);

        bytes = new byte[5];
        byteBuf.readBytes(bytes);
        dispatchId = Message.bcd2Str(bytes);

        bytes = new byte[5];
        byteBuf.readBytes(bytes);
        deliveryId = Message.bcd2Str(bytes);

        dispatchCardNo = decodeString(byteBuf,8);
        deliveryCardNo = decodeString(byteBuf,8);
        dispatchKg = byteBuf.readInt();
        deliveryKg = byteBuf.readInt();
        staffNoLen = byteBuf.readByte();
        staffNo = decodeString(byteBuf,staffNoLen);

        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        productionId = Message.bcd2Str(bytes);
        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        specId = Message.bcd2Str(bytes);
        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        technologyId = Message.bcd2Str(bytes);
        bytes = new byte[4];
        byteBuf.readBytes(bytes);
        batchId = Message.bcd2Str(bytes);

        recordTime = byteBuf.readInt();
    }

    @Override
    public int code() {
        return MID;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(String dispatchId) {
        this.dispatchId = dispatchId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDispatchCardNo() {
        return dispatchCardNo;
    }

    public void setDispatchCardNo(String dispatchCardNo) {
        this.dispatchCardNo = dispatchCardNo;
    }

    public String getDeliveryCardNo() {
        return deliveryCardNo;
    }

    public void setDeliveryCardNo(String deliveryCardNo) {
        this.deliveryCardNo = deliveryCardNo;
    }

    public int getDispatchKg() {
        return dispatchKg;
    }

    public void setDispatchKg(int dispatchKg) {
        this.dispatchKg = dispatchKg;
    }

    public int getDeliveryKg() {
        return deliveryKg;
    }

    public void setDeliveryKg(int deliveryKg) {
        this.deliveryKg = deliveryKg;
    }

    public int getStaffNoLen() {
        return staffNoLen;
    }

    public void setStaffNoLen(int staffNoLen) {
        this.staffNoLen = staffNoLen;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        staffNoLen = staffNo.getBytes(Charset.forName("utf-8")).length;
        this.staffNo = staffNo;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public int getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(int recordTime) {
        this.recordTime = recordTime;
    }
}
