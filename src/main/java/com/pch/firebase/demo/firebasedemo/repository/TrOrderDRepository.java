package com.pch.firebase.demo.firebasedemo.repository;

import com.pch.firebase.demo.firebasedemo.entity.TrOrderDEntity;
import com.pch.firebase.demo.firebasedemo.entity.TrOrderDEntityPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrOrderDRepository extends CrudRepository<TrOrderDEntity, TrOrderDEntityPK> {
}
