package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "time_price", schema = "pms", catalog = "")
public class TimePrice {
    private int id;
    private String departmentId;
    private Integer price;
    private Integer beginTime;
    private Integer endTime;
    private Short type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "department_id")
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
    @Column(name = "type")
    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimePrice timePrice = (TimePrice) o;
        return id == timePrice.id &&
                Objects.equals(departmentId, timePrice.departmentId) &&
                Objects.equals(price, timePrice.price) &&
                Objects.equals(beginTime, timePrice.beginTime) &&
                Objects.equals(endTime, timePrice.endTime) &&
                Objects.equals(type, timePrice.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departmentId, price, beginTime, endTime, type);
    }
}
