package com.example.hello_world.file.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Service
public class AsyncFileStorageService {

    private final ThreadPoolTaskExecutor taskExecutor;

    public AsyncFileStorageService(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    @Async("taskExecutor")
    public void printThreadPoolStatus() {
        int activeCount = taskExecutor.getThreadPoolExecutor().getActiveCount();
        int poolSize = taskExecutor.getThreadPoolExecutor().getPoolSize();
        int corePoolSize = taskExecutor.getCorePoolSize();
        int maxPoolSize = taskExecutor.getMaxPoolSize();
        int queueSize = taskExecutor.getThreadPoolExecutor().getQueue().size();
        String threadName = Thread.currentThread().getName();

        System.out.println("Active threads: " + activeCount);
        System.out.println("Pool size: " + poolSize);
        System.out.println("Core pool size: " + corePoolSize);
        System.out.println("Max pool size: " + maxPoolSize);
        System.out.println("Queue size: " + queueSize);
        System.out.println("Current thread name: " + threadName);
    }
}
