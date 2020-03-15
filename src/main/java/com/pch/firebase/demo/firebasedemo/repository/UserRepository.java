package com.pch.firebase.demo.firebasedemo.repository;

import com.pch.firebase.demo.firebasedemo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
