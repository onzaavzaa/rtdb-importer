package com.pch.firebase.demo.firebasedemo.service;

import com.pch.firebase.demo.firebasedemo.entity.TrOrderDEntity;
import com.pch.firebase.demo.firebasedemo.repository.TrOrderDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncOrderDetailService {

    @Autowired
    private TrOrderDRepository trOrderDRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> saveAll(List<TrOrderDEntity> trOrderDEntities) throws InterruptedException {
        String taskId = UUID.randomUUID().toString();
        System.out.println("Start save OrderDetail "+  taskId);
        trOrderDRepository.saveAll(trOrderDEntities);
        System.out.println("Done save OrderDetail "+ taskId + " at "+ new Date());
        return CompletableFuture.completedFuture("GoodJob");
    }
}
