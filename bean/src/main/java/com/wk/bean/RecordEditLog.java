package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "record_edit_log", schema = "pms", catalog = "")
public class RecordEditLog {
    private int id;
    private String equipmentId;
    private String oldProductionId;
    private String newProductionId;
    private String oldBatchId;
    private String newBatchId;
    private String oldSpecId;
    private String newSpecId;
    private String oldTechnologyId;
    private String newTechnologyId;
    private Integer oldPrice;
    private Integer newPrice;
    private Integer beginTime;
    private Integer endTime;
    private Integer updateTime;
    private String append;
    private String operateUserId;
    private String customerId;
    private String oldProductionName;
    private String newProductionName;
    private String oldBatchName;
    private String newBatchName;
    private String oldSpecName;
    private String newSpecName;
    private String oldTechnologyName;
    private String newTechnologyName;
    private String userName;
    private String subEquipmentId;

    @Transient
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
    @Column(name = "equipment_id")
    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    @Basic
    @Column(name = "old_production_id")
    public String getOldProductionId() {
        return oldProductionId;
    }

    public void setOldProductionId(String oldProductionId) {
        this.oldProductionId = oldProductionId;
    }

    @Basic
    @Column(name = "new_production_id")
    public String getNewProductionId() {
        return newProductionId;
    }

    public void setNewProductionId(String newProductionId) {
        this.newProductionId = newProductionId;
    }

    @Basic
    @Column(name = "old_batch_id")
    public String getOldBatchId() {
        return oldBatchId;
    }

    public void setOldBatchId(String oldBatchId) {
        this.oldBatchId = oldBatchId;
    }

    @Basic
    @Column(name = "new_batch_id")
    public String getNewBatchId() {
        return newBatchId;
    }

    public void setNewBatchId(String newBatchId) {
        this.newBatchId = newBatchId;
    }

    @Basic
    @Column(name = "old_spec_id")
    public String getOldSpecId() {
        return oldSpecId;
    }

    public void setOldSpecId(String oldSpecId) {
        this.oldSpecId = oldSpecId;
    }

    @Basic
    @Column(name = "new_spec_id")
    public String getNewSpecId() {
        return newSpecId;
    }

    public void setNewSpecId(String newSpecId) {
        this.newSpecId = newSpecId;
    }

    @Basic
    @Column(name = "old_technology_id")
    public String getOldTechnologyId() {
        return oldTechnologyId;
    }

    public void setOldTechnologyId(String oldTechnologyId) {
        this.oldTechnologyId = oldTechnologyId;
    }

    @Basic
    @Column(name = "new_technology_id")
    public String getNewTechnologyId() {
        return newTechnologyId;
    }

    public void setNewTechnologyId(String newTechnologyId) {
        this.newTechnologyId = newTechnologyId;
    }

    @Basic
    @Column(name = "old_price")
    public Integer getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Integer oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Basic
    @Column(name = "new_price")
    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    @Basic
    @Column(name = "begin_time")
    public Integer getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Integer beginTime) {
        this.beginTime = beginTime;
    }

    @Basic
    @Column(name = "end_time")
    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
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

    @Basic
    @Column(name = "operate_user_id")
    public String getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(String operateUserId) {
        this.operateUserId = operateUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordEditLog that = (RecordEditLog) o;
        return id == that.id &&
                Objects.equals(equipmentId, that.equipmentId) &&
                Objects.equals(oldProductionId, that.oldProductionId) &&
                Objects.equals(newProductionId, that.newProductionId) &&
                Objects.equals(oldBatchId, that.oldBatchId) &&
                Objects.equals(newBatchId, that.newBatchId) &&
                Objects.equals(oldSpecId, that.oldSpecId) &&
                Objects.equals(newSpecId, that.newSpecId) &&
                Objects.equals(oldTechnologyId, that.oldTechnologyId) &&
                Objects.equals(newTechnologyId, that.newTechnologyId) &&
                Objects.equals(oldPrice, that.oldPrice) &&
                Objects.equals(newPrice, that.newPrice) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(append, that.append) &&
                Objects.equals(operateUserId, that.operateUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, equipmentId, oldProductionId, newProductionId, oldBatchId, newBatchId, oldSpecId, newSpecId, oldTechnologyId, newTechnologyId, oldPrice, newPrice, beginTime, endTime, updateTime, append, operateUserId);
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
    @Column(name = "old_production_name")
    public String getOldProductionName() {
        return oldProductionName;
    }

    public void setOldProductionName(String oldProductionName) {
        this.oldProductionName = oldProductionName;
    }

    @Basic
    @Column(name = "new_production_name")
    public String getNewProductionName() {
        return newProductionName;
    }

    public void setNewProductionName(String newProductionName) {
        this.newProductionName = newProductionName;
    }

    @Basic
    @Column(name = "old_batch_name")
    public String getOldBatchName() {
        return oldBatchName;
    }

    public void setOldBatchName(String oldBatchName) {
        this.oldBatchName = oldBatchName;
    }

    @Basic
    @Column(name = "new_batch_name")
    public String getNewBatchName() {
        return newBatchName;
    }

    public void setNewBatchName(String newBatchName) {
        this.newBatchName = newBatchName;
    }

    @Basic
    @Column(name = "old_spec_name")
    public String getOldSpecName() {
        return oldSpecName;
    }

    public void setOldSpecName(String oldSpecName) {
        this.oldSpecName = oldSpecName;
    }

    @Basic
    @Column(name = "new_spec_name")
    public String getNewSpecName() {
        return newSpecName;
    }

    public void setNewSpecName(String newSpecName) {
        this.newSpecName = newSpecName;
    }

    @Basic
    @Column(name = "old_technology_name")
    public String getOldTechnologyName() {
        return oldTechnologyName;
    }

    public void setOldTechnologyName(String oldTechnologyName) {
        this.oldTechnologyName = oldTechnologyName;
    }

    @Basic
    @Column(name = "new_technology_name")
    public String getNewTechnologyName() {
        return newTechnologyName;
    }

    public void setNewTechnologyName(String newTechnologyName) {
        this.newTechnologyName = newTechnologyName;
    }

    @Basic
    @Column(name = "sub_equipment_id")
    public String getSubEquipmentId() {
        return subEquipmentId;
    }

    public void setSubEquipmentId(String subEquipmentId) {
        this.subEquipmentId = subEquipmentId;
    }
}
