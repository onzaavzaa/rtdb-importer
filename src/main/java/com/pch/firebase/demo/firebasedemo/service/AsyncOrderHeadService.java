package com.pch.firebase.demo.firebasedemo.service;

import com.pch.firebase.demo.firebasedemo.entity.TrOrderDEntity;
import com.pch.firebase.demo.firebasedemo.entity.TrOrderHEntity;
import com.pch.firebase.demo.firebasedemo.repository.TrOrderDRepository;
import com.pch.firebase.demo.firebasedemo.repository.TrOrderHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncOrderHeadService {
    @Autowired
    private TrOrderHRepository trOrderHRepository;

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> saveAll(List<TrOrderHEntity> trOrderHEntities) throws InterruptedException {
        String taskId = UUID.randomUUID().toString();
        System.out.println("Start save OrderHead taskID: "+ taskId);
        trOrderHRepository.saveAll(trOrderHEntities);
        System.out.println("Done save OrderHead "+ taskId + " at "+ new Date());
        return CompletableFuture.completedFuture("GoodJob");
    }
}
