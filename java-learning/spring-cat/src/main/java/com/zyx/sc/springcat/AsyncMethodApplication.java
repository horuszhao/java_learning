package com.zyx.sc.springcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@EnableAsync
public class AsyncMethodApplication {

	public static void main(String[] args) {
		// close the application context to shut down the custom ExecutorService
		SpringApplication.run(AsyncMethodApplication.class, args).close();
	}




}
