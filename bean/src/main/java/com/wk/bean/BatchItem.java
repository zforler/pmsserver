package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "batch_item", schema = "pms", catalog = "")
public class BatchItem {
    private int id;
    private String itemId;
    private String batchId;
    private Integer beginTime;
    private Integer endTime;
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
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }




    @Basic
    @Column(name = "batch_id")
    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
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
        BatchItem batchItem = (BatchItem) o;
        return Objects.equals(id, batchItem.id) &&
                Objects.equals(batchId, batchItem.batchId) &&
                Objects.equals(beginTime, batchItem.beginTime) &&
                Objects.equals(endTime, batchItem.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, batchId, beginTime, endTime);
    }
}
