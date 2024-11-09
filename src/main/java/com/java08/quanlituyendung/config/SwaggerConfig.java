package com.java08.quanlituyendung.config;

import com.java08.quanlituyendung.auth.AuthenticationService;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Autowired
    AuthenticationService authenticationService;

    // Tạo SecurityScheme cho Bearer Authentication với JWT
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("Bearer");
    }

    // Cấu hình Swagger Docket (SpringFox Swagger 2)
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.java08.quanlituyendung"))  // Chỉ định package của API
                .paths(PathSelectors.any())  // Áp dụng cho tất cả các endpoint
                .build();
    }

    // Cấu hình OpenAPI (Swagger 3) với JWT Bearer Authentication
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info()
                        .title("Recruitment API")
                        .description("Quản lý tuyển dụng")
                        .version("1.0")
                        .contact(new Contact().name("Nguyen Le Quoc Khanh")
                                .email("nguyenkhanh2kpi@gmail.com"))
                        .license(new License()
                                .name("API License")
                                .url("https://www.facebook.com/profile.php?id=100058506963756")));
    }
}
