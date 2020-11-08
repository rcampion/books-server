package com.rkc.zds;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@ComponentScan("com.rkc.zds")
@SpringBootApplication
@EnableAsync
public class BooksServerApp {

	private static final Logger LOG = LoggerFactory.getLogger(BooksServerApp.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BooksServerApp.class, args);
	}

}
