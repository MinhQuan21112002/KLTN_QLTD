package com.java08.quanlituyendung;

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
		// Fetch PORT environment variable for Railway
		String port = System.getenv("PORT");
		if (port == null) {
			port = "8080"; // Default to 8080 if PORT not set
		}
		SpringApplication.run(QuanlituyendungApplication.class, new String[] { "--server.port=" + port });
	}

	@Bean
	public WebMvcConfigurer configurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOriginPatterns("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowCredentials(true)
						.maxAge(3600);
			}
		};
	}
}
