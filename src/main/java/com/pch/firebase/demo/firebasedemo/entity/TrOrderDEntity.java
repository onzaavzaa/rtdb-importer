package com.pch.firebase.demo.firebasedemo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TR_ORDER_D", schema = "dbo", catalog = "Sample2")
@IdClass(TrOrderDEntityPK.class)
public class TrOrderDEntity {
    private String tohCode;
    private int todSeq;
    private String mpdCode;
    private String todNumber;
    private int todQty;
    private int todPrice;
    private int todAmount;
    private int todWinRate;
    private int todWinAmount;
    private String todWinStatus;
    private Timestamp todCreateDate;
    private String todCreateBy;
    private Timestamp todUpdateDate;
    private String todUpdateBy;

    @Id
    @Column(name = "TOH_CODE")
    public String getTohCode() {
        return tohCode;
    }

    public void setTohCode(String tohCode) {
        this.tohCode = tohCode;
    }

    @Id
    @Column(name = "TOD_SEQ")
    public int getTodSeq() {
        return todSeq;
    }

    public void setTodSeq(int todSeq) {
        this.todSeq = todSeq;
    }

    @Id
    @Column(name = "MPD_CODE")
    public String getMpdCode() {
        return mpdCode;
    }

    public void setMpdCode(String mpdCode) {
        this.mpdCode = mpdCode;
    }

    @Id
    @Column(name = "TOD_NUMBER")
    public String getTodNumber() {
        return todNumber;
    }

    public void setTodNumber(String todNumber) {
        this.todNumber = todNumber;
    }

    @Basic
    @Column(name = "TOD_QTY")
    public int getTodQty() {
        return todQty;
    }

    public void setTodQty(int todQty) {
        this.todQty = todQty;
    }

    @Basic
    @Column(name = "TOD_PRICE")
    public int getTodPrice() {
        return todPrice;
    }

    public void setTodPrice(int todPrice) {
        this.todPrice = todPrice;
    }

    @Basic
    @Column(name = "TOD_AMOUNT")
    public int getTodAmount() {
        return todAmount;
    }

    public void setTodAmount(int todAmount) {
        this.todAmount = todAmount;
    }

    @Basic
    @Column(name = "TOD_WIN_RATE")
    public int getTodWinRate() {
        return todWinRate;
    }

    public void setTodWinRate(int todWinRate) {
        this.todWinRate = todWinRate;
    }

    @Basic
    @Column(name = "TOD_WIN_AMOUNT")
    public int getTodWinAmount() {
        return todWinAmount;
    }

    public void setTodWinAmount(int todWinAmount) {
        this.todWinAmount = todWinAmount;
    }

    @Basic
    @Column(name = "TOD_WIN_STATUS")
    public String getTodWinStatus() {
        return todWinStatus;
    }

    public void setTodWinStatus(String todWinStatus) {
        this.todWinStatus = todWinStatus;
    }

    @Basic
    @Column(name = "TOD_CREATE_DATE")
    public Timestamp getTodCreateDate() {
        return todCreateDate;
    }

    public void setTodCreateDate(Timestamp todCreateDate) {
        this.todCreateDate = todCreateDate;
    }

    @Basic
    @Column(name = "TOD_CREATE_BY")
    public String getTodCreateBy() {
        return todCreateBy;
    }

    public void setTodCreateBy(String todCreateBy) {
        this.todCreateBy = todCreateBy;
    }

    @Basic
    @Column(name = "TOD_UPDATE_DATE")
    public Timestamp getTodUpdateDate() {
        return todUpdateDate;
    }

    public void setTodUpdateDate(Timestamp todUpdateDate) {
        this.todUpdateDate = todUpdateDate;
    }

    @Basic
    @Column(name = "TOD_UPDATE_BY")
    public String getTodUpdateBy() {
        return todUpdateBy;
    }

    public void setTodUpdateBy(String todUpdateBy) {
        this.todUpdateBy = todUpdateBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrOrderDEntity that = (TrOrderDEntity) o;
        return todSeq == that.todSeq &&
                todQty == that.todQty &&
                todPrice == that.todPrice &&
                todAmount == that.todAmount &&
                todWinRate == that.todWinRate &&
                todWinAmount == that.todWinAmount &&
                Objects.equals(tohCode, that.tohCode) &&
                Objects.equals(mpdCode, that.mpdCode) &&
                Objects.equals(todNumber, that.todNumber) &&
                Objects.equals(todWinStatus, that.todWinStatus) &&
                Objects.equals(todCreateDate, that.todCreateDate) &&
                Objects.equals(todCreateBy, that.todCreateBy) &&
                Objects.equals(todUpdateDate, that.todUpdateDate) &&
                Objects.equals(todUpdateBy, that.todUpdateBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tohCode, todSeq, mpdCode, todNumber, todQty, todPrice, todAmount, todWinRate, todWinAmount, todWinStatus, todCreateDate, todCreateBy, todUpdateDate, todUpdateBy);
    }
}
