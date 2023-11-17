package com.zdslogic.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@PropertySource({ "classpath:local.properties" })
@EnableAsync
public class AppConfig {
	/*
	 * @Bean("apiKeyService")
	 * 
	 * @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON) public
	 * ApiKeyServiceImpl getAccountService() { return new ApiKeyServiceImpl(); }
	 * 
	 * @Bean public Executor taskExecutor() {
	 * 
	 * return new SimpleAsyncTaskExecutor(); }
	 */
}
