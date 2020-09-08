package com.wk.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Record {
    private String recordId;
    private String customerId;
    private String equipmentId;
    private String dispatchSubId;
    private String deliverySubId;
    private String dispatchCardNo;
    private String deliveryCardNo;
    private Integer priceType;
    private BigDecimal dispatchKg;
    private BigDecimal deliveryCount;
    private String deliveryKg;
    private BigDecimal yield;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String staffNo;
    private String staffName;
    private Integer staffType;
    private String productionId;
    private String productionName;
    private String specId;
    private String specName;
    private String technologyId;
    private String technologyName;
    private String shiftId;
    private String shiftName;
    private Integer delayTime;
    private Integer recordTime;
    private Integer reportTime;
    private Integer calcTime;
    private String append;
    private String batchId;
    private String batchName;

    @Basic
    @Column(name = "yield")
    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
    }

    @Id
    @Column(name = "record_id")
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Basic
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "equipment_id")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "dispatch_sub_id")
    public String getDispatchSubId() {
        return dispatchSubId;
    }

    public void setDispatchSubId(String dispatchSubId) {
        this.dispatchSubId = dispatchSubId;
    }

    @Basic
    @Column(name = "delivery_sub_id")
    public String getDeliverySubId() {
        return deliverySubId;
    }

    public void setDeliverySubId(String deliverySubId) {
        this.deliverySubId = deliverySubId;
    }

    @Basic
    @Column(name = "dispatch_card_no")
    public String getDispatchCardNo() {
        return dispatchCardNo;
    }

    public void setDispatchCardNo(String dispatchCardNo) {
        this.dispatchCardNo = dispatchCardNo;
    }

    @Basic
    @Column(name = "delivery_card_no")
    public String getDeliveryCardNo() {
        return deliveryCardNo;
    }

    public void setDeliveryCardNo(String deliveryCardNo) {
        this.deliveryCardNo = deliveryCardNo;
    }

    @Basic
    @Column(name = "price_type")
    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    @Basic
    @Column(name = "dispatch_kg")
    public BigDecimal getDispatchKg() {
        return dispatchKg;
    }

    public void setDispatchKg(BigDecimal dispatchKg) {
        this.dispatchKg = dispatchKg;
    }

    @Basic
    @Column(name = "delivery_count")
    public BigDecimal getDeliveryCount() {
        return deliveryCount;
    }

    public void setDeliveryCount(BigDecimal deliveryCount) {
        this.deliveryCount = deliveryCount;
    }

    @Basic
    @Column(name = "delivery_kg")
    public String getDeliveryKg() {
        return deliveryKg;
    }

    public void setDeliveryKg(String deliveryKg) {
        this.deliveryKg = deliveryKg;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "total_price")
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "staff_no")
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    @Basic
    @Column(name = "staff_name")
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Basic
    @Column(name = "staff_type")
    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    @Basic
    @Column(name = "production_id")
    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    @Basic
    @Column(name = "production_name")
    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    @Basic
    @Column(name = "spec_id")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "spec_name")
    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    @Basic
    @Column(name = "technology_id")
    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    @Basic
    @Column(name = "technology_name")
    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    @Basic
    @Column(name = "shift_id")
    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    @Basic
    @Column(name = "shift_name")
    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    @Basic
    @Column(name = "delay_time")
    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    @Basic
    @Column(name = "record_time")
    public Integer getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Integer recordTime) {
        this.recordTime = recordTime;
    }

    @Basic
    @Column(name = "report_time")
    public Integer getReportTime() {
        return reportTime;
    }

    public void setReportTime(Integer reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "calc_time")
    public Integer getCalcTime() {
        return calcTime;
    }

    public void setCalcTime(Integer calcTime) {
        this.calcTime = calcTime;
    }

    @Basic
    @Column(name = "append")
    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(recordId, record.recordId) &&
                Objects.equals(customerId, record.customerId) &&
                Objects.equals(equipmentId, record.equipmentId) &&
                Objects.equals(dispatchSubId, record.dispatchSubId) &&
                Objects.equals(deliverySubId, record.deliverySubId) &&
                Objects.equals(dispatchCardNo, record.dispatchCardNo) &&
                Objects.equals(deliveryCardNo, record.deliveryCardNo) &&
                Objects.equals(priceType, record.priceType) &&
                Objects.equals(dispatchKg, record.dispatchKg) &&
                Objects.equals(deliveryCount, record.deliveryCount) &&
                Objects.equals(deliveryKg, record.deliveryKg) &&
                Objects.equals(price, record.price) &&
                Objects.equals(totalPrice, record.totalPrice) &&
                Objects.equals(staffNo, record.staffNo) &&
                Objects.equals(staffName, record.staffName) &&
                Objects.equals(staffType, record.staffType) &&
                Objects.equals(productionId, record.productionId) &&
                Objects.equals(productionName, record.productionName) &&
                Objects.equals(specId, record.specId) &&
                Objects.equals(specName, record.specName) &&
                Objects.equals(technologyId, record.technologyId) &&
                Objects.equals(technologyName, record.technologyName) &&
                Objects.equals(shiftId, record.shiftId) &&
                Objects.equals(shiftName, record.shiftName) &&
                Objects.equals(delayTime, record.delayTime) &&
                Objects.equals(recordTime, record.recordTime) &&
                Objects.equals(reportTime, record.reportTime) &&
                Objects.equals(calcTime, record.calcTime) &&
                Objects.equals(append, record.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, customerId, equipmentId, dispatchSubId, deliverySubId, dispatchCardNo, deliveryCardNo, priceType, dispatchKg, deliveryCount, deliveryKg, price, totalPrice, staffNo, staffName, staffType, productionId, productionName, specId, specName, technologyId, technologyName, shiftId, shiftName, delayTime, recordTime, reportTime, calcTime, append);
    }

    @Basic
    @Column(name = "batch_id")
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    @Basic
    @Column(name = "batch_name")
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }
}
