package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "menu_authority", schema = "pms", catalog = "")
@IdClass(SysMenuAuthorityPK.class)
public class MenuAuthority {
	private String roleId;
	private int menuId;
	private int authed;


	@Id
	@Column(name = "role_id", nullable = false, length = 8)
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Id
	@Column(name = "menu_id", nullable = false)
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	@Basic
	@Column(name = "authed", nullable = true)
	public int getAuthed() {
		return authed;
	}

	public void setAuthed(int authed) {
		this.authed = authed;
	}

	@Override
	public boolean equals(Object o) {


		return true;
	}

	@Override
	public int hashCode() {
		int result = roleId != null ? roleId.hashCode() : 0;
		result = 31 * result + menuId;
		return result;
	}
}
