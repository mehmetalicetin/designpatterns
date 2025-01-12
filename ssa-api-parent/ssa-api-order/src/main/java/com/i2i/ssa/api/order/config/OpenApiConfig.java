package com.i2i.ssa.api.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
    public static final String ORDER_API_TITLE   = "ORDER API";
    public static final String ORDER_API_VERSION = "0.0.1";


    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(ORDER_API_TITLE)
                        .version(ORDER_API_VERSION)
                        .description("This API provides endpoints to manage customer orders, including order creation, retrieval, update, and cancellation."));
    }
}