package com.pch.firebase.demo.firebasedemo.repository;

import com.pch.firebase.demo.firebasedemo.User;
import com.pch.firebase.demo.firebasedemo.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, String> {
}
