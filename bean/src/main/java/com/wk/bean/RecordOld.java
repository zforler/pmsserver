package com.wk.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "record_old", schema = "pms", catalog = "")
public class RecordOld {
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
    private BigDecimal deliveryKg;
    private BigDecimal yield;
    private BigDecimal price;
    private BigDecimal totalPrice;
    private String priceId;
    private String staffNo;
    private String staffName;
    private Integer staffType;
    private String departmentId;
    private String departmentName;
    private String productionId;
    private String productionName;
    private String specId;
    private String specName;
    private String technologyId;
    private String technologyName;
    private String shiftId;
    private String shiftName;
    private Integer delayTime;
    private String batchId;
    private String batchName;
    private Integer recordTime;
    private Integer reportTime;
    private Integer calcTime;
    private Integer year;
    private Integer month;
    private Integer day;
    private String append;
    private int id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
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
    public BigDecimal getDeliveryKg() {
        return deliveryKg;
    }

    public void setDeliveryKg(BigDecimal deliveryKg) {
        this.deliveryKg = deliveryKg;
    }

    @Basic
    @Column(name = "yield")
    public BigDecimal getYield() {
        return yield;
    }

    public void setYield(BigDecimal yield) {
        this.yield = yield;
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
    @Column(name = "price_id")
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
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
    @Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
    @Column(name = "year")
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Basic
    @Column(name = "month")
    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    @Basic
    @Column(name = "day")
    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
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
        RecordOld recordOld = (RecordOld) o;
        return Objects.equals(recordId, recordOld.recordId) &&
                Objects.equals(customerId, recordOld.customerId) &&
                Objects.equals(equipmentId, recordOld.equipmentId) &&
                Objects.equals(dispatchSubId, recordOld.dispatchSubId) &&
                Objects.equals(deliverySubId, recordOld.deliverySubId) &&
                Objects.equals(dispatchCardNo, recordOld.dispatchCardNo) &&
                Objects.equals(deliveryCardNo, recordOld.deliveryCardNo) &&
                Objects.equals(priceType, recordOld.priceType) &&
                Objects.equals(dispatchKg, recordOld.dispatchKg) &&
                Objects.equals(deliveryCount, recordOld.deliveryCount) &&
                Objects.equals(deliveryKg, recordOld.deliveryKg) &&
                Objects.equals(yield, recordOld.yield) &&
                Objects.equals(price, recordOld.price) &&
                Objects.equals(totalPrice, recordOld.totalPrice) &&
                Objects.equals(priceId, recordOld.priceId) &&
                Objects.equals(staffNo, recordOld.staffNo) &&
                Objects.equals(staffName, recordOld.staffName) &&
                Objects.equals(staffType, recordOld.staffType) &&
                Objects.equals(departmentId, recordOld.departmentId) &&
                Objects.equals(departmentName, recordOld.departmentName) &&
                Objects.equals(productionId, recordOld.productionId) &&
                Objects.equals(productionName, recordOld.productionName) &&
                Objects.equals(specId, recordOld.specId) &&
                Objects.equals(specName, recordOld.specName) &&
                Objects.equals(technologyId, recordOld.technologyId) &&
                Objects.equals(technologyName, recordOld.technologyName) &&
                Objects.equals(shiftId, recordOld.shiftId) &&
                Objects.equals(shiftName, recordOld.shiftName) &&
                Objects.equals(delayTime, recordOld.delayTime) &&
                Objects.equals(batchId, recordOld.batchId) &&
                Objects.equals(batchName, recordOld.batchName) &&
                Objects.equals(recordTime, recordOld.recordTime) &&
                Objects.equals(reportTime, recordOld.reportTime) &&
                Objects.equals(calcTime, recordOld.calcTime) &&
                Objects.equals(year, recordOld.year) &&
                Objects.equals(month, recordOld.month) &&
                Objects.equals(day, recordOld.day) &&
                Objects.equals(append, recordOld.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId, customerId, equipmentId, dispatchSubId, deliverySubId, dispatchCardNo, deliveryCardNo, priceType, dispatchKg, deliveryCount, deliveryKg, yield, price, totalPrice, priceId, staffNo, staffName, staffType, departmentId, departmentName, productionId, productionName, specId, specName, technologyId, technologyName, shiftId, shiftName, delayTime, batchId, batchName, recordTime, reportTime, calcTime, year, month, day, append);
    }
}
