package com.pch.firebase.demo.firebasedemo.rtdb.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {


    private String orderCode;
    private Long orderSeq;
    private Double orderTotal;
    private String createDate;
    private String createBy;
    private String updateDate;
    private String updateBy;
    private String roundCode;
    private String roundName;
    private String cycleCode;
    private String cycleEndDate;
    private String customerCode;
    private String customerName;
    private String orderStatus;
    private Long winTotal;
    private String winStatus;

    private List<OrderItem> orderItem;


}
