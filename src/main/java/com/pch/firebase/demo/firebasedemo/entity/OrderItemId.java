package com.pch.firebase.demo.firebasedemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class OrderItemId implements Serializable {

    @Column(name = "TOH_CODE")
    private String orderCode;

    @Column(name = "TOD_SEQ")
    private Long seq;

    @Column(name = "MPD_CODE")
    private String productCode;

    @Column(name = "TOD_NUMBER")
    private String productNumber;


}
