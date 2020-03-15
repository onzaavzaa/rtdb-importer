package com.pch.firebase.demo.firebasedemo.repository;

import com.pch.firebase.demo.firebasedemo.entity.TrOrderHEntity;
import com.pch.firebase.demo.firebasedemo.entity.TrOrderHEntityPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrOrderHRepository  extends CrudRepository<TrOrderHEntity, TrOrderHEntityPK> {
}
