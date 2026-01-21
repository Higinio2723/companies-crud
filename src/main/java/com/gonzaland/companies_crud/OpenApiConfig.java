package com.gonzaland.companies_crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Companies CRUD API",
                version = "1.0.0",
                description = "This is a CRUD API for managing companies."
        )
)
public class OpenApiConfig {
}
