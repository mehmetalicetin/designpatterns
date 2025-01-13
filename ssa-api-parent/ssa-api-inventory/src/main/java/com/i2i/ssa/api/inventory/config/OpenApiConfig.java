package com.i2i.ssa.api.inventory.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
    public static final String INVENTORY_API_TITLE   = "INVENTORY API";
    public static final String INVENTORY_API_VERSION = "0.0.1";


    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(INVENTORY_API_TITLE)
                        .version(INVENTORY_API_VERSION)
                        .description("This API provides endpoints to manage inventory data, including adding, updating, retrieving, and deleting products and stock levels."));
    }
}