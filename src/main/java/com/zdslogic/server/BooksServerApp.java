package com.zdslogic.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@ComponentScan("com.zdslogic")
@SpringBootApplication
@EnableAsync
public class BooksServerApp {

	private static final Logger LOG = LoggerFactory.getLogger(BooksServerApp.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BooksServerApp.class, args);
	}

}
