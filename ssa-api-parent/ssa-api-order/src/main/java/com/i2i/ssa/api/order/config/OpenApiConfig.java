package com.i2i.ssa.api.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author mehmetali.cetin
 * @date 2023-01-11 1:04 p.m.
 */
@Configuration
public class OpenApiConfig {
    public static final String ORDER_API         = "ORDER API";
    public static final String ORDER_API_TITLE   = "ORDER API";
    public static final String ORDER_API_VERSION = "0.0.1";
    public static final String ORDER_API_TAG     = "ORDER-controller";

    private Tag createTag(String name) {
        return new Tag().name(name);
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(ORDER_API_TITLE)
                        .version(ORDER_API_VERSION)
                        .description("This API provides endpoints to manage customer orders, including order creation, retrieval, update, and cancellation."));
    }
}