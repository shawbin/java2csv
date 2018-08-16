package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 配置异步调用线程注入
 */
@Configuration
public class TaskExecutorConfig {

    @Bean
    public Executor getExecutor() {

        return new SimpleAsyncTaskExecutor();
    }
}
