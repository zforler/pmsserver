package com.wk.bean;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Spec {
    private int id;
    private String specId;
    private String specName;
    private String customerId;
    private String productionId;
    private Integer createTime;
    private Integer beginTime;
    private Integer endTime;
    private String productionName;
    @Transient
    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
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
    @Column(name = "spec_id")
    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    @Basic
    @Column(name = "spec_name")
    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
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
    @Column(name = "production_id")
    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spec spec = (Spec) o;
        return id == spec.id &&
                Objects.equals(specId, spec.specId) &&
                Objects.equals(specName, spec.specName) &&
                Objects.equals(customerId, spec.customerId) &&
                Objects.equals(productionId, spec.productionId) &&
                Objects.equals(createTime, spec.createTime) &&
                Objects.equals(beginTime, spec.beginTime) &&
                Objects.equals(endTime, spec.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specId, specName, customerId, productionId, createTime, beginTime, endTime);
    }
}
