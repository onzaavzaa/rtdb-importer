package com.pch.firebase.demo.firebasedemo.rtdb.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
public class OrderItem {

    private Long seq;
    private String productCode;
    private String productName;
    private String productNumber;
    private Long qty;
    private Long price;
    private Long amount;
    private Long winRate;
    private Long winAmount;
    private String createDate;
    private String createBy;
    private String updateDate;
    private String updateBy;
    private String winStatus;

}
