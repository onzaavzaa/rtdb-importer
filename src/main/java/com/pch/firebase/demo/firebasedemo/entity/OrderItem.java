package com.pch.firebase.demo.firebasedemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "TR_ORDER_D")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemId orderItemId;

    //private String productName;

    @Column(name = "TOD_QTY")
    private Long qty;
    @Column(name = "TOD_PRICE")
    private Long price;
    @Column(name = "TOD_AMOUNT")
    private Long amount;
    @Column(name = "TOD_WIN_RATE")
    private Long winRate;
    @Column(name = "TOD_WIN_AMOUNT")
    private Long winAmount;
    @Column(name = "TOD_CREATE_DATE")
    private Date createDate;
    @Column(name = "TOD_CREATE_BY")
    private String createBy;
    @Column(name = "TOD_UPDATE_DATE")
    private Date updateDate;
    @Column(name = "TOD_UPDATE_BY")
    private String updateBy;
    @Column(name = "TOD_WIN_STATUS")
    private String winStatus;

/*    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "TOH_CODE", insertable=false, updatable=false),
            @JoinColumn(name = "TOD_SEQ", insertable=false, updatable=false),
            @JoinColumn(name = "MPD_CODE", insertable=false, updatable=false),
            @JoinColumn(name = "TOD_NUMBER", insertable=false, updatable=false)
    })
    private Order order;*/

}
