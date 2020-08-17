package com.wk.bean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "user_info", schema = "h_cloud", catalog = "")
public class UserInfo {
	private String userId;
	private String userName;

	private String name;
	private String nickName;
	private String phone;
	private Integer phoneVerified;
	private String email;
	private Integer emailVerified;
	private Integer gender;
	private Integer birthday;
	private String address;
	private Integer certificateType;
	private String certificateNo;
	private Integer userType;
	private Integer updateTime;
	private Integer createTime;

	private String operatorId;
	private String enterpriseId;
	private Integer source;
	private String createrUserId;

	private Integer elecDiscount;

	private Integer serviceDiscount;

	private Integer payType;
	private Integer provinceId;
	private Integer cityId;
	private Integer countyId;
    private BigDecimal overdraft;
	private String append;
	private Integer lockReason;
	private Integer status;
	private String portrait;
	private Integer maintainType;
	@Basic
	@Column(name = "maintain_type")
	public Integer getMaintainType() {
		return maintainType;
	}

	public void setMaintainType(Integer maintainType) {
		this.maintainType = maintainType;
	}

	@Basic
	@Column(name = "portrait")
	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	@Basic
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}



	public void setEmailVerified(int emailVerified) {
		this.emailVerified = emailVerified;
	}

    @Basic
    @Column(name = "overdraft", nullable = true, precision = 2)
    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }

    @Id
	@Column(name = "user_id", nullable = false, length = 12)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "user_name", nullable = false, length = 32)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 16)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "nick_name", nullable = true, length = 16)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Basic
	@Column(name = "phone", nullable = true, length = 16)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Basic
	@Column(name = "phone_verified", nullable = true)
	public Integer getPhoneVerified() {
		return phoneVerified;
	}

    public void setPhoneVerified(Integer phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

	@Basic
	@Column(name = "email", nullable = true, length = 32)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Basic
	@Column(name = "email_verified", nullable = true)
	public Integer getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Integer emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Basic
	@Column(name = "gender", nullable = true)
	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Basic
	@Column(name = "birthday", nullable = true)
	public Integer getBirthday() {
		return birthday;
	}

	public void setBirthday(Integer birthday) {
		this.birthday = birthday;
	}

	@Basic
	@Column(name = "address", nullable = true, length = 255)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Basic
	@Column(name = "certificate_type", nullable = true)
	public Integer getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	@Basic
	@Column(name = "certificate_no", nullable = true, length = 32)
	public String getCertificateNo() {
		return certificateNo;
	}

	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}

	@Basic
	@Column(name = "user_type", nullable = false)
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	@Basic
	@Column(name = "update_time", nullable = false)
	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	@Basic
	@Column(name = "create_time", nullable = false)
	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Basic
	@Column(name = "operator_id", nullable = true, length = 4)
	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	@Basic
	@Column(name = "enterprise_id", nullable = true)
	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Basic
	@Column(name = "source", nullable = false)
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	@Basic
	@Column(name = "creater_user_id", nullable = true, length = 12)
	public String getCreaterUserId() {
		return createrUserId;
	}

	public void setCreaterUserId(String createrUserId) {
		this.createrUserId = createrUserId;
	}

	@Basic
	@Column(name = "elec_discount", nullable = true)
	public Integer getElecDiscount() {
		return elecDiscount;
	}

	public void setElecDiscount(Integer elecDiscount) {
		this.elecDiscount = elecDiscount;
	}

	@Basic
	@Column(name = "service_discount", nullable = true)
	public Integer getServiceDiscount() {
		return serviceDiscount;
	}

	public void setServiceDiscount(Integer serviceDiscount) {
		this.serviceDiscount = serviceDiscount;
	}

	@Basic
	@Column(name = "pay_type", nullable = true)
	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Basic
	@Column(name = "province_id", nullable = true)
	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	@Basic
	@Column(name = "city_id", nullable = true)
	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	@Basic
	@Column(name = "county_id", nullable = true)
	public Integer getCountyId() {
		return countyId;
	}

	public void setCountyId(Integer countyId) {
		this.countyId = countyId;
	}

	@Basic
	@Column(name = "append", nullable = true, length = 255)
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

		UserInfo user = (UserInfo) o;

		if (!userType.equals(user.userType)) return false;
		if (!updateTime.equals(user.updateTime)) return false;
		if (!createTime.equals(user.createTime)) return false;
		if (!source.equals(user.source)) return false;
		if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
		if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
		if (name != null ? !name.equals(user.name) : user.name != null) return false;
		if (nickName != null ? !nickName.equals(user.nickName) : user.nickName != null) return false;
		if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
//		if (phoneVerified != null ? !phoneVerified.equals(user.phoneVerified) : user.phoneVerified != null)
//			return false;
		if (email != null ? !email.equals(user.email) : user.email != null) return false;
//		if (emailVerified != null ? !emailVerified.equals(user.emailVerified) : user.emailVerified != null)
//			return false;
		if (gender != null ? !gender.equals(user.gender) : user.gender != null) return false;
		if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
		if (address != null ? !address.equals(user.address) : user.address != null) return false;
		if (certificateType != user.certificateType) return false;
		if (certificateNo != null ? !certificateNo.equals(user.certificateNo) : user.certificateNo != null)
			return false;
		if (operatorId != null ? !operatorId.equals(user.operatorId) : user.operatorId != null) return false;
		if (enterpriseId != null ? !enterpriseId.equals(user.enterpriseId) : user.enterpriseId != null) return false;
		if (createrUserId != null ? !createrUserId.equals(user.createrUserId) : user.createrUserId != null)
			return false;
		if (elecDiscount != null ? !elecDiscount.equals(user.elecDiscount) : user.elecDiscount != null) return false;
		if (serviceDiscount != null ? !serviceDiscount.equals(user.serviceDiscount) : user.serviceDiscount != null)
			return false;
		if (!payType.equals(user.payType)) return false;
		if (provinceId != null ? !provinceId.equals(user.provinceId) : user.provinceId != null) return false;
		if (cityId != null ? !cityId.equals(user.cityId) : user.cityId != null) return false;
		if (countyId != null ? !countyId.equals(user.countyId) : user.countyId != null) return false;
		if (append != null ? !append.equals(user.append) : user.append != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = userId != null ? userId.hashCode() : 0;
		result = 31 * result + (userName != null ? userName.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
		result = 31 * result + (phone != null ? phone.hashCode() : 0);
//		result = 31 * result + (phoneVerified != null ? phoneVerified.hashCode() : 0);
		result = 31 * result + (email != null ? email.hashCode() : 0);
//		result = 31 * result + (emailVerified != null ? emailVerified.hashCode() : 0);
		result = 31 * result + (gender != null ? gender.hashCode() : 0);
		result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (certificateType != null ? certificateType.hashCode() : 0);
		result = 31 * result + (certificateNo != null ? certificateNo.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
		result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
		result = 31 * result + (enterpriseId != null ? enterpriseId.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
		result = 31 * result + (createrUserId != null ? createrUserId.hashCode() : 0);
		result = 31 * result + (elecDiscount != null ? elecDiscount.hashCode() : 0);
		result = 31 * result + (serviceDiscount != null ? serviceDiscount.hashCode() : 0);
		result = 31 * result + (payType != null ? payType.hashCode() : 0);;
		result = 31 * result + (provinceId != null ? provinceId.hashCode() : 0);
		result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
		result = 31 * result + (countyId != null ? countyId.hashCode() : 0);
		result = 31 * result + (append != null ? append.hashCode() : 0);
		return result;
	}

	@Basic
	@Column(name = "lock_reason", nullable = true)
	public Integer getLockReason() {
		return lockReason;
	}

	public void setLockReason(Integer lockReason) {
		this.lockReason = lockReason;
	}
}
