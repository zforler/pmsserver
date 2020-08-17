package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "sys_log", schema = "h_cloud", catalog = "")
public class SysLog {
	private long id;
	private String clientIp;
	private String requestUri;
	private String userId;
	private String requestMethod;
	private String paramData;
	private String returnData;
	private Long requestTime;
	private Long returnTime;
	private Long operateTime;
	private String httpStatus;
	private String remark;
	private Integer reportTime;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "client_ip", nullable = true, length = 15)
	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Basic
	@Column(name = "request_uri", nullable = true, length = 255)
	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	@Basic
	@Column(name = "user_id", nullable = true, length = 12)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Basic
	@Column(name = "request_method", nullable = true, length = 10)
	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	@Basic
	@Column(name = "param_data", nullable = true, length = -1)
	public String getParamData() {
		return paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	@Basic
	@Column(name = "return_data", nullable = true, length = -1)
	public String getReturnData() {
		return returnData;
	}

	public void setReturnData(String returnData) {
		this.returnData = returnData;
	}

	@Basic
	@Column(name = "request_time", nullable = true)
	public Long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Long requestTime) {
		this.requestTime = requestTime;
	}

	@Basic
	@Column(name = "return_time", nullable = true)
	public Long getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Long returnTime) {
		this.returnTime = returnTime;
	}

	@Basic
	@Column(name = "operate_time", nullable = true)
	public Long getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Long operateTime) {
		this.operateTime = operateTime;
	}

	@Basic
	@Column(name = "http_status", nullable = true, length = 20)
	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}

	@Basic
	@Column(name = "remark", nullable = true, length = 255)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Basic
	@Column(name = "report_time", nullable = true)
	public Integer getReportTime() {
		return reportTime;
	}

	public void setReportTime(Integer reportTime) {
		this.reportTime = reportTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysLog sysLog = (SysLog) o;

		if (id != sysLog.id) return false;
		if (clientIp != null ? !clientIp.equals(sysLog.clientIp) : sysLog.clientIp != null) return false;
		if (requestUri != null ? !requestUri.equals(sysLog.requestUri) : sysLog.requestUri != null) return false;
		if (userId != null ? !userId.equals(sysLog.userId) : sysLog.userId != null) return false;
		if (requestMethod != null ? !requestMethod.equals(sysLog.requestMethod) : sysLog.requestMethod != null)
			return false;
		if (paramData != null ? !paramData.equals(sysLog.paramData) : sysLog.paramData != null) return false;
		if (returnData != null ? !returnData.equals(sysLog.returnData) : sysLog.returnData != null) return false;
		if (requestTime != null ? !requestTime.equals(sysLog.requestTime) : sysLog.requestTime != null) return false;
		if (returnTime != null ? !returnTime.equals(sysLog.returnTime) : sysLog.returnTime != null) return false;
		if (operateTime != null ? !operateTime.equals(sysLog.operateTime) : sysLog.operateTime != null) return false;
		if (httpStatus != null ? !httpStatus.equals(sysLog.httpStatus) : sysLog.httpStatus != null) return false;
		if (remark != null ? !remark.equals(sysLog.remark) : sysLog.remark != null) return false;
		if (reportTime != null ? !reportTime.equals(sysLog.reportTime) : sysLog.reportTime != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));
		result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
		result = 31 * result + (requestUri != null ? requestUri.hashCode() : 0);
		result = 31 * result + (userId != null ? userId.hashCode() : 0);
		result = 31 * result + (requestMethod != null ? requestMethod.hashCode() : 0);
		result = 31 * result + (paramData != null ? paramData.hashCode() : 0);
		result = 31 * result + (returnData != null ? returnData.hashCode() : 0);
		result = 31 * result + (requestTime != null ? requestTime.hashCode() : 0);
		result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
		result = 31 * result + (operateTime != null ? operateTime.hashCode() : 0);
		result = 31 * result + (httpStatus != null ? httpStatus.hashCode() : 0);
		result = 31 * result + (remark != null ? remark.hashCode() : 0);
		result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
		return result;
	}
}
