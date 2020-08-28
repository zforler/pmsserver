package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "staff_card", schema = "pms", catalog = "")
public class StaffCard {
    private int id;
    private String staffId;
    private String cardId;
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
    @Column(name = "staff_id")
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "card_id")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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
        StaffCard staffCard = (StaffCard) o;
        return id == staffCard.id &&
                Objects.equals(staffId, staffCard.staffId) &&
                Objects.equals(cardId, staffCard.cardId) &&
                Objects.equals(beginTime, staffCard.beginTime) &&
                Objects.equals(endTime, staffCard.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staffId, cardId, beginTime, endTime);
    }
}
