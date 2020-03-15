package com.pch.firebase.demo.firebasedemo.repository;

import com.pch.firebase.demo.firebasedemo.entity.Order;
import com.pch.firebase.demo.firebasedemo.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository  extends CrudRepository<OrderItem, String> {

}
