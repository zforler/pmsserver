package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sub_equipment_calc_log", schema = "pms", catalog = "")
public class SubEquipmentCalcLog {
    private int id;
    private String subEquipmentId;
    private Integer type;
    private Integer beginTime;
    private Integer endTime;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sub_equipment_id")
    public String getSubEquipmentId() {
        return subEquipmentId;
    }

    public void setSubEquipmentId(String subEquipmentId) {
        this.subEquipmentId = subEquipmentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubEquipmentCalcLog that = (SubEquipmentCalcLog) o;
        return id == that.id &&
                Objects.equals(subEquipmentId, that.subEquipmentId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subEquipmentId, type, beginTime, endTime);
    }
}
