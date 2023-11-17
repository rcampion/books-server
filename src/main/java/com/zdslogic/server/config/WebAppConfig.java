package com.zdslogic.server.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.zdslogic", "com.zdslogic.books.service" })
public class WebAppConfig implements WebMvcConfigurer {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {

				/*
				 * // registry.addMapping("/**").allowCredentials(true).allowedOrigins(
				 * "http://www.zdslogic-development.com:4200");
				 * registry.addMapping("/**").allowedOrigins("*").allowCredentials(true).
				 * allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE");
				 */
				registry.addMapping("/**")
						.allowedOrigins(List.of("https://www.zdslogic.com", "http://www.richardcampion.com",
								"http://localhost:4200", "http://localhost:8089").toString())
						.allowCredentials(true).allowedMethods("OPTIONS", "GET", "PUT", "POST", "DELETE");
			}
		};
	}

}
