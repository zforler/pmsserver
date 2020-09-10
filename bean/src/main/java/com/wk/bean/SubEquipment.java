package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sub_equipment", schema = "pms", catalog = "")
public class SubEquipment {
    private String subEquipmentId;
    private String subEquipmentName;
    private Integer type;
    private String equipmentId;
    private Integer createTime;
    private Integer updateTime;
    private String append;
    private Integer staffTypeCalc;
    private Integer shiftCalc;

    @Id
    @Column(name = "sub_equipment_id")
    public String getSubEquipmentId() {
        return subEquipmentId;
    }

    public void setSubEquipmentId(String subEquipmentId) {
        this.subEquipmentId = subEquipmentId;
    }

    @Basic
    @Column(name = "sub_equipment_name")
    public String getSubEquipmentName() {
        return subEquipmentName;
    }

    public void setSubEquipmentName(String subEquipmentName) {
        this.subEquipmentName = subEquipmentName;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        SubEquipment that = (SubEquipment) o;
        return Objects.equals(subEquipmentId, that.subEquipmentId) &&
                Objects.equals(subEquipmentName, that.subEquipmentName) &&
                Objects.equals(type, that.type) &&
                Objects.equals(equipmentId, that.equipmentId) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(append, that.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subEquipmentId, subEquipmentName, type, equipmentId, createTime, updateTime, append);
    }

    @Basic
    @Column(name = "staff_type_calc")
    public Integer getStaffTypeCalc() {
        return staffTypeCalc;
    }

    public void setStaffTypeCalc(Integer staffTypeCalc) {
        this.staffTypeCalc = staffTypeCalc;
    }

    @Basic
    @Column(name = "shift_calc")
    public Integer getShiftCalc() {
        return shiftCalc;
    }

    public void setShiftCalc(Integer shiftCalc) {
        this.shiftCalc = shiftCalc;
    }
}
