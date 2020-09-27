package com.wk.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Card {
    private String cardId;
    private String cardNo;
    private String cardName;
    private Integer cardType;
    private String customerId;
    private Integer status;
    private Integer createTime;
    private Integer updateTime;
    private String append;
    private String staffId;
    private String staffName;
    private int beginTime;
    private String cardOutNo;

    @Transient
    public int getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    @Transient
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    @Transient
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    @Id
    @Column(name = "card_id")
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "card_no")
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Basic
    @Column(name = "card_name")
    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Basic
    @Column(name = "card_type")
    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
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
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
    @Column(name = "update_time")
    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "append")
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
        Card card = (Card) o;
        return Objects.equals(cardId, card.cardId) &&
                Objects.equals(cardNo, card.cardNo) &&
                Objects.equals(cardName, card.cardName) &&
                Objects.equals(cardType, card.cardType) &&
                Objects.equals(customerId, card.customerId) &&
                Objects.equals(status, card.status) &&
                Objects.equals(createTime, card.createTime) &&
                Objects.equals(updateTime, card.updateTime) &&
                Objects.equals(append, card.append);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardNo, cardName, cardType, customerId, status, createTime, updateTime, append);
    }

    @Basic
    @Column(name = "card_out_no")
    public String getCardOutNo() {
        return cardOutNo;
    }

    public void setCardOutNo(String cardOutNo) {
        this.cardOutNo = cardOutNo;
    }
}
