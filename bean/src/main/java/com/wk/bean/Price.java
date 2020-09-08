package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Price {
    private int id;
    private String priceId;
    private String priceName;
    private Integer staffType;
    private String shiftId;
    private Integer price;
    private Integer activeTime;
    private Integer reactiveTime;
    private String append;
    private Integer createTime;
    private Integer updateTime;
    private String customerId;
    private String productionId;
    private String specId;
    private String technologyId;
    private Integer sendTime;
    private Integer status;
    private String productionName;
    private String specName;
    private String technologyName;
    private String shiftName;
    private Integer priceType;
    @Basic
    @Column(name = "price_type")
    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    @Transient
    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }
    @Transient
    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
    @Transient
    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }
    @Transient
    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

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
    @Column(name = "price_id")
    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    @Basic
    @Column(name = "price_name")
    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
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
    @Column(name = "shift_id")
    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "active_time")
    public Integer getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Integer activeTime) {
        this.activeTime = activeTime;
    }

    @Basic
    @Column(name = "reactive_time")
    public Integer getReactiveTime() {
        return reactiveTime;
    }

    public void setReactiveTime(Integer reactiveTime) {
        this.reactiveTime = reactiveTime;
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
        Price price1 = (Price) o;
        return id == price1.id &&
                Objects.equals(priceId, price1.priceId) &&
                Objects.equals(priceName, price1.priceName) &&
                Objects.equals(staffType, price1.staffType) &&
                Objects.equals(shiftId, price1.shiftId) &&
                Objects.equals(price, price1.price) &&
                Objects.equals(activeTime, price1.activeTime) &&
                Objects.equals(reactiveTime, price1.reactiveTime) &&
                Objects.equals(append, price1.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, priceId, priceName, staffType, shiftId, price, activeTime, reactiveTime, append);
    }

    @Basic
    @Column(name = "create_time")
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
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
    @Column(name = "production_id")
    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
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
    @Column(name = "technology_id")
    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    @Basic
    @Column(name = "send_time")
    public Integer getSendTime() {
        return sendTime;
    }

    public void setSendTime(Integer sendTime) {
        this.sendTime = sendTime;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
