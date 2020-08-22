package com.wk.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class SysMenuAuthorityPK implements Serializable {
	private String roleId;
	private int menuId;

	@Column(name = "role_id", nullable = false, length = 8)
	@Id
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(name = "menu_id", nullable = false)
	@Id
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysMenuAuthorityPK that = (SysMenuAuthorityPK) o;

		if (menuId != that.menuId) return false;
		if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = roleId != null ? roleId.hashCode() : 0;
		result = 31 * result + menuId;
		return result;
	}
}
