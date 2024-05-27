package com.gulshan.spring_boot_microservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI personServicOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Person Service API"))
                .externalDocs(new ExternalDocumentation()
                        .description("Person's Wiki Documentation")
                        .url("http://dummy.com/docs"));
    }
}
