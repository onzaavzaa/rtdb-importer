package com.pch.firebase.demo.firebasedemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Embeddable
public class OrderId implements Serializable {

    @Column(name = "TOH_CODE")
    private String orderCode;

    @Column(name = "TOH_CUSTOMER_CODE")
    private String customerCode;

    @Column(name = "MRD_CODE")
    private String roundCode;

    @Column(name = "TCR_CODE")
    private String cycleCode;



}
