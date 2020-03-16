package com.pch.firebase.demo.firebasedemo.rtdb.model;

import lombok.Data;

@Data
public class ImportOrderResponse {

    boolean status;
    String msg;
    String desc;
    Object data;
}
