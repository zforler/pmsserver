package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Staff {
    private String staffId;
    private String staffName;
    private int sex;
    private int entryTime;
    private int leaveTime;
    private int status;
    private int staffType;
    private String phone;
    private String address;
    private String idcard;
    private String customerId;
    private int createTime;
    private int updateTime;
    private String append;
    private String departmentId;
    private String departmentName;
    private String parents;
    @Transient
    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
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
    @Column(name = "staff_type")
    public int getStaffType() {
        return staffType;
    }

    public void setStaffType(int staffType) {
        this.staffType = staffType;
    }

    @Transient
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Transient
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Id
    @Column(name = "staff_id")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
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
    @Column(name = "sex")
    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "entry_time")
    public int getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }

    @Basic
    @Column(name = "leave_time")
    public int getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(int leaveTime) {
        this.leaveTime = leaveTime;
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
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    @Column(name = "idcard")
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Basic
    @Column(name = "create_time")
    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
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
        Staff staff = (Staff) o;
        return Objects.equals(staffId, staff.staffId) &&
                Objects.equals(staffName, staff.staffName) &&
                Objects.equals(sex, staff.sex) &&
                Objects.equals(entryTime, staff.entryTime) &&
                Objects.equals(leaveTime, staff.leaveTime) &&
                Objects.equals(status, staff.status) &&
                Objects.equals(phone, staff.phone) &&
                Objects.equals(address, staff.address) &&
                Objects.equals(idcard, staff.idcard) &&
                Objects.equals(createTime, staff.createTime) &&
                Objects.equals(updateTime, staff.updateTime) &&
                Objects.equals(append, staff.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId, staffName, sex, entryTime, leaveTime, status, phone, address, idcard, createTime, updateTime, append);
    }
}
