package com.pch.firebase.demo.firebasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TrOrderDEntityPK implements Serializable {
    private String tohCode;
    private int todSeq;
    private String mpdCode;
    private String todNumber;

    @Column(name = "TOH_CODE")
    @Id
    public String getTohCode() {
        return tohCode;
    }

    public void setTohCode(String tohCode) {
        this.tohCode = tohCode;
    }

    @Column(name = "TOD_SEQ")
    @Id
    public int getTodSeq() {
        return todSeq;
    }

    public void setTodSeq(int todSeq) {
        this.todSeq = todSeq;
    }

    @Column(name = "MPD_CODE")
    @Id
    public String getMpdCode() {
        return mpdCode;
    }

    public void setMpdCode(String mpdCode) {
        this.mpdCode = mpdCode;
    }

    @Column(name = "TOD_NUMBER")
    @Id
    public String getTodNumber() {
        return todNumber;
    }

    public void setTodNumber(String todNumber) {
        this.todNumber = todNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrOrderDEntityPK that = (TrOrderDEntityPK) o;
        return todSeq == that.todSeq &&
                Objects.equals(tohCode, that.tohCode) &&
                Objects.equals(mpdCode, that.mpdCode) &&
                Objects.equals(todNumber, that.todNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tohCode, todSeq, mpdCode, todNumber);
    }
}
