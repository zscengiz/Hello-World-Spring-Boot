package com.example.hello_world.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(100);  // Minimum çalışan thread sayısı
        executor.setMaxPoolSize(100);  // Maksimum çalışan thread sayısı
        executor.setQueueCapacity(100);  // Kuyruğa eklenebilecek maksimum iş sayısı
        executor.setThreadNamePrefix("Async-");  // Thread ismi öneki
        executor.initialize();
        return executor;
    }

}
