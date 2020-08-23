package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "sys_dic", schema = "pms", catalog = "")
public class SysDic {
	private String code;
	private String name;
	private String append;

	@Id
	@Column(name = "code", nullable = false, length = 64)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

		SysDic sysDic = (SysDic) o;

		if (code != null ? !code.equals(sysDic.code) : sysDic.code != null) return false;
		if (name != null ? !name.equals(sysDic.name) : sysDic.name != null) return false;
		if (append != null ? !append.equals(sysDic.append) : sysDic.append != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = code != null ? code.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (append != null ? append.hashCode() : 0);
		return result;
	}
}
