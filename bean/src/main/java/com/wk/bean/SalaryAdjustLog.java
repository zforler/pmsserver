package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "salary_adjust_log", schema = "pms", catalog = "")
public class SalaryAdjustLog {
    private int id;
    private String staffNo;
    private String customerId;
    private Integer adjust;
    private Integer subsidy;
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer updateTime;
    private String operateUserId;
    private String userName;
    private String append;
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
    @Column(name = "staff_no")
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
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
    @Column(name = "adjust")
    public Integer getAdjust() {
        return adjust;
    }

    public void setAdjust(Integer adjust) {
        this.adjust = adjust;
    }
    @Basic
    @Column(name = "subsidy")
    public Integer getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(Integer subsidy) {
        this.subsidy = subsidy;
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
    @Column(name = "update_time")
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "operate_user_id")
    public String getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(String operateUserId) {
        this.operateUserId = operateUserId;
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
        SalaryAdjustLog that = (SalaryAdjustLog) o;
        return id == that.id &&
                Objects.equals(staffNo, that.staffNo) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(adjust, that.adjust) &&
                Objects.equals(subsidy, that.subsidy) &&
                Objects.equals(year, that.year) &&
                Objects.equals(month, that.month) &&
                Objects.equals(day, that.day) &&
                Objects.equals(updateTime, that.updateTime) &&
                Objects.equals(operateUserId, that.operateUserId) &&
                Objects.equals(append, that.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staffNo, customerId, adjust, subsidy, year, month, day, updateTime, operateUserId, append);
    }
}
