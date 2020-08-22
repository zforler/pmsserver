package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "user_info", schema = "pms", catalog = "")
public class UserInfo {
    private String userId;
    private String customerId;
    private String userName;
    private String password;
    private String realName;
    private Integer sex;
    private String phone;
    private Integer createTime;
    private Integer updateTime;
    private String roleId;
    private String roleName;
    private Integer status;
    private String append;
    @Transient
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "customer_id")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "real_name")
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

        UserInfo userInfo = (UserInfo) o;

        if (userId != null ? !userId.equals(userInfo.userId) : userInfo.userId != null) return false;
        if (userName != null ? !userName.equals(userInfo.userName) : userInfo.userName != null) return false;
        if (realName != null ? !realName.equals(userInfo.realName) : userInfo.realName != null) return false;
        if (sex != null ? !sex.equals(userInfo.sex) : userInfo.sex != null) return false;
        if (phone != null ? !phone.equals(userInfo.phone) : userInfo.phone != null) return false;
        if (createTime != null ? !createTime.equals(userInfo.createTime) : userInfo.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(userInfo.updateTime) : userInfo.updateTime != null) return false;
        if (roleId != null ? !roleId.equals(userInfo.roleId) : userInfo.roleId != null) return false;
        if (append != null ? !append.equals(userInfo.append) : userInfo.append != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (realName != null ? realName.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (append != null ? append.hashCode() : 0);
        return result;
    }
}
