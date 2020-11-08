package com.rkc.zds.books.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.rkc.zds", "com.rkc.zds.books.service"  })
public class WebAppConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				//registry.addMapping("/**").allowCredentials(true).allowedOrigins("http://www.zdslogic-development.com:4200");
				registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE");
			}
		};
	}
	
}
