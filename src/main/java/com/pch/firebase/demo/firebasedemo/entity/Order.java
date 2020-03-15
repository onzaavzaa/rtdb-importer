package com.pch.firebase.demo.firebasedemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name="TR_ORDER_H")
public class Order implements Serializable {

    @EmbeddedId
    private OrderId orderId;

    @Column(name = "TOH_SEQ")
    private Long orderSeq;

    @Column(name = "TOH_TOTAL")
    private Long orderTotal;

    @Column(name = "TOH_CREATE_DATE")
    private Date createDate;

    @Column(name = "TOH_CREATE_BY")
    private String createBy;

    @Column(name = "TOH_UPDATE_DATE")
    private Date updateDate;

    @Column(name = "TOH_UPDATE_BY")
    private String updateBy;

/*    private String roundName;

    private Date cycleEndDate;

    private String customerName;
    private Long winTotal;*/

    @Column(name = "TOH_STATUS")
    private String orderStatus;

    @Column(name = "TOH_WIN_STATUS")
    private String winStatus;

/*    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem;*/


}
