package com.pch.firebase.demo.firebasedemo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncSave {

    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> findUser(String num) throws InterruptedException {
        System.out.println("Task number "+ num + " Start.");
        Thread.sleep(5000L);
        System.out.println("Task number "+ num + " Done.");
        return CompletableFuture.completedFuture("GoodJob");
    }
}
