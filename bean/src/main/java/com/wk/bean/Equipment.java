package com.wk.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Equipment {
    private String equipmentId;
    private String equipmentName;
    private Integer equipmentType;
    private String customerId;
    private Integer status;
    private Integer createTime;
    private Integer updateTime;
    private String append;
    private Integer subCount;

    @Id
    @Column(name = "equipment_id")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "equipment_name")
    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Basic
    @Column(name = "equipment_type")
    public Integer getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Integer equipmentType) {
        this.equipmentType = equipmentType;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        Equipment equipment = (Equipment) o;
        return Objects.equals(equipmentId, equipment.equipmentId) &&
                Objects.equals(equipmentName, equipment.equipmentName) &&
                Objects.equals(equipmentType, equipment.equipmentType) &&
                Objects.equals(customerId, equipment.customerId) &&
                Objects.equals(status, equipment.status) &&
                Objects.equals(createTime, equipment.createTime) &&
                Objects.equals(updateTime, equipment.updateTime) &&
                Objects.equals(append, equipment.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipmentId, equipmentName, equipmentType, customerId, status, createTime, updateTime, append);
    }

    @Basic
    @Column(name = "sub_count")
    public Integer getSubCount() {
        return subCount;
    }

    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }
}
