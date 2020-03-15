package com.pch.firebase.demo.firebasedemo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TrOrderHEntityPK implements Serializable {
    private String tohCode;
    private String tohCustomerCode;
    private String mrdCode;
    private String tcrCode;

    @Column(name = "TOH_CODE")
    @Id
    public String getTohCode() {
        return tohCode;
    }

    public void setTohCode(String tohCode) {
        this.tohCode = tohCode;
    }

    @Column(name = "TOH_CUSTOMER_CODE")
    @Id
    public String getTohCustomerCode() {
        return tohCustomerCode;
    }

    public void setTohCustomerCode(String tohCustomerCode) {
        this.tohCustomerCode = tohCustomerCode;
    }

    @Column(name = "MRD_CODE")
    @Id
    public String getMrdCode() {
        return mrdCode;
    }

    public void setMrdCode(String mrdCode) {
        this.mrdCode = mrdCode;
    }

    @Column(name = "TCR_CODE")
    @Id
    public String getTcrCode() {
        return tcrCode;
    }

    public void setTcrCode(String tcrCode) {
        this.tcrCode = tcrCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrOrderHEntityPK that = (TrOrderHEntityPK) o;
        return Objects.equals(tohCode, that.tohCode) &&
                Objects.equals(tohCustomerCode, that.tohCustomerCode) &&
                Objects.equals(mrdCode, that.mrdCode) &&
                Objects.equals(tcrCode, that.tcrCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tohCode, tohCustomerCode, mrdCode, tcrCode);
    }
}
