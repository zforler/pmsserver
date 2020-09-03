package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Shift {
    private int id;
    private String shiftId;
    private String shiftName;
    private String customerId;
    private Integer activeTime;
    private Integer reactiveTime;
    private Integer delayTime;
    private Integer beginTime;
    private Integer endTime;
    private Integer createTime;

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
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
    @Column(name = "delay_time")
    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
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
    @Column(name = "create_time")
    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shift shift = (Shift) o;
        return id == shift.id &&
                Objects.equals(shiftId, shift.shiftId) &&
                Objects.equals(shiftName, shift.shiftName) &&
                Objects.equals(customerId, shift.customerId) &&
                Objects.equals(activeTime, shift.activeTime) &&
                Objects.equals(reactiveTime, shift.reactiveTime) &&
                Objects.equals(delayTime, shift.delayTime) &&
                Objects.equals(beginTime, shift.beginTime) &&
                Objects.equals(endTime, shift.endTime) &&
                Objects.equals(createTime, shift.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shiftId, shiftName, customerId, activeTime, reactiveTime, delayTime, beginTime, endTime, createTime);
    }
}
