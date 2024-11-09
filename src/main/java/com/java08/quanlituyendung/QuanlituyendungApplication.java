package com.java08.quanlituyendung;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAsync
public class QuanlituyendungApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuanlituyendungApplication.class, args);
	}

	@Value("${ALLOWED_ORIGIN:https://alert-emotion-production.up.railway.app/}")
	private String allowedOrigin;

	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins(allowedOrigin)
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowCredentials(true)
						.maxAge(3600);
			}
		};
	}
}
