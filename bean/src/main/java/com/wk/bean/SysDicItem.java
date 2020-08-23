package com.wk.bean;

import javax.persistence.*;

@Entity
@Table(name = "sys_dic_item", schema = "pms", catalog = "")
public class SysDicItem {
	private int id;
	private String code;
	private String itemCode;
	private String itemName;
	private Integer itemOrder;
	private String parentCode;
	private Integer itemLevel;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "code", nullable = true, length = 64)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Basic
	@Column(name = "item_code", nullable = true, length = 64)
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	@Basic
	@Column(name = "item_name", nullable = true, length = 64)
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Basic
	@Column(name = "item_order", nullable = true)
	public Integer getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(Integer itemOrder) {
		this.itemOrder = itemOrder;
	}

	@Basic
	@Column(name = "parent_code", nullable = true, length = 64)
	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	@Basic
	@Column(name = "item_level", nullable = true)
	public Integer getItemLevel() {
		return itemLevel;
	}

	public void setItemLevel(Integer itemLevel) {
		this.itemLevel = itemLevel;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		SysDicItem that = (SysDicItem) o;

		if (id != that.id) return false;
		if (code != null ? !code.equals(that.code) : that.code != null) return false;
		if (itemCode != null ? !itemCode.equals(that.itemCode) : that.itemCode != null) return false;
		if (itemName != null ? !itemName.equals(that.itemName) : that.itemName != null) return false;
		if (itemOrder != null ? !itemOrder.equals(that.itemOrder) : that.itemOrder != null) return false;
		if (parentCode != null ? !parentCode.equals(that.parentCode) : that.parentCode != null) return false;
		if (itemLevel != null ? !itemLevel.equals(that.itemLevel) : that.itemLevel != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = 31 * result + (code != null ? code.hashCode() : 0);
		result = 31 * result + (itemCode != null ? itemCode.hashCode() : 0);
		result = 31 * result + (itemName != null ? itemName.hashCode() : 0);
		result = 31 * result + (itemOrder != null ? itemOrder.hashCode() : 0);
		result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
		result = 31 * result + (itemLevel != null ? itemLevel.hashCode() : 0);
		return result;
	}
}
