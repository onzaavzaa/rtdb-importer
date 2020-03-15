package com.pch.firebase.demo.firebasedemo.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "TR_ORDER_H", schema = "dbo", catalog = "Sample2")
@IdClass(TrOrderHEntityPK.class)
public class TrOrderHEntity {
    private String tohCode;
    private String tohCustomerCode;
    private String mrdCode;
    private String tcrCode;
    private int tohSeq;
    private int tohTotal;
    private Timestamp tohCreateDate;
    private String tohCreateBy;
    private Timestamp tohUpdateDate;
    private String tohUpdateBy;
    private String tohStatus;
    private String tohWinStatus;

    @Id
    @Column(name = "TOH_CODE")
    public String getTohCode() {
        return tohCode;
    }

    public void setTohCode(String tohCode) {
        this.tohCode = tohCode;
    }

    @Id
    @Column(name = "TOH_CUSTOMER_CODE")
    public String getTohCustomerCode() {
        return tohCustomerCode;
    }

    public void setTohCustomerCode(String tohCustomerCode) {
        this.tohCustomerCode = tohCustomerCode;
    }

    @Id
    @Column(name = "MRD_CODE")
    public String getMrdCode() {
        return mrdCode;
    }

    public void setMrdCode(String mrdCode) {
        this.mrdCode = mrdCode;
    }

    @Id
    @Column(name = "TCR_CODE")
    public String getTcrCode() {
        return tcrCode;
    }

    public void setTcrCode(String tcrCode) {
        this.tcrCode = tcrCode;
    }

    @Basic
    @Column(name = "TOH_SEQ")
    public int getTohSeq() {
        return tohSeq;
    }

    public void setTohSeq(int tohSeq) {
        this.tohSeq = tohSeq;
    }

    @Basic
    @Column(name = "TOH_TOTAL")
    public int getTohTotal() {
        return tohTotal;
    }

    public void setTohTotal(int tohTotal) {
        this.tohTotal = tohTotal;
    }

    @Basic
    @Column(name = "TOH_CREATE_DATE")
    public Timestamp getTohCreateDate() {
        return tohCreateDate;
    }

    public void setTohCreateDate(Timestamp tohCreateDate) {
        this.tohCreateDate = tohCreateDate;
    }

    @Basic
    @Column(name = "TOH_CREATE_BY")
    public String getTohCreateBy() {
        return tohCreateBy;
    }

    public void setTohCreateBy(String tohCreateBy) {
        this.tohCreateBy = tohCreateBy;
    }

    @Basic
    @Column(name = "TOH_UPDATE_DATE")
    public Timestamp getTohUpdateDate() {
        return tohUpdateDate;
    }

    public void setTohUpdateDate(Timestamp tohUpdateDate) {
        this.tohUpdateDate = tohUpdateDate;
    }

    @Basic
    @Column(name = "TOH_UPDATE_BY")
    public String getTohUpdateBy() {
        return tohUpdateBy;
    }

    public void setTohUpdateBy(String tohUpdateBy) {
        this.tohUpdateBy = tohUpdateBy;
    }

    @Basic
    @Column(name = "TOH_STATUS")
    public String getTohStatus() {
        return tohStatus;
    }

    public void setTohStatus(String tohStatus) {
        this.tohStatus = tohStatus;
    }

    @Basic
    @Column(name = "TOH_WIN_STATUS")
    public String getTohWinStatus() {
        return tohWinStatus;
    }

    public void setTohWinStatus(String tohWinStatus) {
        this.tohWinStatus = tohWinStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrOrderHEntity that = (TrOrderHEntity) o;
        return tohSeq == that.tohSeq &&
                tohTotal == that.tohTotal &&
                Objects.equals(tohCode, that.tohCode) &&
                Objects.equals(tohCustomerCode, that.tohCustomerCode) &&
                Objects.equals(mrdCode, that.mrdCode) &&
                Objects.equals(tcrCode, that.tcrCode) &&
                Objects.equals(tohCreateDate, that.tohCreateDate) &&
                Objects.equals(tohCreateBy, that.tohCreateBy) &&
                Objects.equals(tohUpdateDate, that.tohUpdateDate) &&
                Objects.equals(tohUpdateBy, that.tohUpdateBy) &&
                Objects.equals(tohStatus, that.tohStatus) &&
                Objects.equals(tohWinStatus, that.tohWinStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tohCode, tohCustomerCode, mrdCode, tcrCode, tohSeq, tohTotal, tohCreateDate, tohCreateBy, tohUpdateDate, tohUpdateBy, tohStatus, tohWinStatus);
    }
}
