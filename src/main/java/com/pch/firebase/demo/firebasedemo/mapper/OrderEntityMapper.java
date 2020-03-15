package com.pch.firebase.demo.firebasedemo.mapper;

import com.pch.firebase.demo.firebasedemo.entity.TrOrderDEntity;
import com.pch.firebase.demo.firebasedemo.entity.TrOrderHEntity;
import com.pch.firebase.demo.firebasedemo.rtdb.model.Order;
import com.pch.firebase.demo.firebasedemo.rtdb.model.OrderItem;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Logger;

@Data
@Service
public class OrderEntityMapper {

    private List<TrOrderHEntity> orderHeadEntities;
    private  List<TrOrderDEntity> orderDetailEntities;

    public void map(List<Order> orderList){

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss z Z (zzzz)");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        TrOrderHEntity hEntity = null;
        TrOrderDEntity dEntity = null;
        orderHeadEntities = new ArrayList<>();
        orderDetailEntities = new ArrayList<>();
        for(Order order: orderList){

            try{
                hEntity = new TrOrderHEntity();
                hEntity.setMrdCode(order.getRoundCode());
                hEntity.setTcrCode(order.getCycleCode());
                hEntity.setTohCode(order.getOrderCode());
                hEntity.setTohCreateBy(order.getCreateBy());
                hEntity.setTohCreateDate(new Timestamp(sdf.parse(formatRtdbDate(order.getCreateDate()) ).getTime()));
                hEntity.setTohCustomerCode(order.getCustomerCode());
                hEntity.setTohSeq(order.getOrderSeq().intValue());
                hEntity.setTohStatus(order.getOrderStatus());
                hEntity.setTohTotal(order.getWinTotal().intValue());
                hEntity.setTohUpdateBy(order.getUpdateBy());
                hEntity.setTohUpdateDate(new Timestamp(sdf.parse(formatRtdbDate(order.getUpdateDate()) ).getTime()));
                hEntity.setTohWinStatus(order.getWinStatus());

                orderHeadEntities.add(hEntity);

             }catch (Exception e){
                 e.printStackTrace();
             }

            try{
                for (OrderItem orderItem: order.getOrderItem() ) {
                    dEntity = new TrOrderDEntity();
                    dEntity.setMpdCode(orderItem.getProductCode());
                    dEntity.setTodAmount(orderItem.getAmount().intValue());
                    dEntity.setTodCreateBy(orderItem.getCreateBy());
                    dEntity.setTodCreateDate(new Timestamp(sdf.parse(formatRtdbDate(orderItem.getCreateDate()) ).getTime()));
                    dEntity.setTodNumber(orderItem.getProductNumber());
                    dEntity.setTodPrice(orderItem.getPrice().intValue());
                    dEntity.setTodQty(orderItem.getQty().intValue());
                    dEntity.setTodSeq(orderItem.getSeq().intValue());
                    dEntity.setTodUpdateBy(orderItem.getUpdateBy());
                    dEntity.setTodUpdateDate(new Timestamp(sdf.parse( formatRtdbDate(order.getUpdateDate()) ).getTime()));
                    dEntity.setTodWinAmount(orderItem.getWinAmount().intValue());
                    dEntity.setTodWinRate(orderItem.getWinRate().intValue());
                    dEntity.setTodWinStatus(orderItem.getWinStatus());
                    dEntity.setTohCode(order.getOrderCode());

                    orderDetailEntities.add(dEntity);
                }

             }catch (Exception e){
        }
       }
    }

    private String formatRtdbDate(String dateStr){
        String strTimezone = dateStr.substring(dateStr.indexOf("+")-2, dateStr.indexOf("+"));

        if(!strTimezone.contains(" ") ){
            dateStr = dateStr.replace("+", " +");
        }

        return  dateStr;
    }

}
