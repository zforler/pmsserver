package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "pms", catalog = "")
public class Customer {
    private String customerId;
    private String company;
    private String address;
    private String concator;
    private String concatorPhone;
    private int status;
    private int equipmentCount;
    private Integer createTime;
    private Integer updateTime;

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Id
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "company")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "concator")
    public String getConcator() {
        return concator;
    }

    public void setConcator(String concator) {
        this.concator = concator;
    }

    @Basic
    @Column(name = "concator_phone")
    public String getConcatorPhone() {
        return concatorPhone;
    }

    public void setConcatorPhone(String concatorPhone) {
        this.concatorPhone = concatorPhone;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "equipment_count")
    public int getEquipmentCount() {
        return equipmentCount;
    }

    public void setEquipmentCount(int equipmentCount) {
        this.equipmentCount = equipmentCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(company, that.company) &&
                Objects.equals(address, that.address) &&
                Objects.equals(concator, that.concator) &&
                Objects.equals(concatorPhone, that.concatorPhone) &&
                Objects.equals(status, that.status) &&
                Objects.equals(equipmentCount, that.equipmentCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, company, address, concator, concatorPhone, status, equipmentCount);
    }
}
