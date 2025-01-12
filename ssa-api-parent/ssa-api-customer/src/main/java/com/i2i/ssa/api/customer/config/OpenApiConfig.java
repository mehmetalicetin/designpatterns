package com.i2i.ssa.api.customer.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {
    public static final String CUSTOMER_API_TITLE   = "CUSTOMER API";
    public static final String CUSTOMER_API_VERSION = "0.0.1";

    private Tag createTag(String name) {
        return new Tag().name(name);
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(CUSTOMER_API_TITLE)
                        .version(CUSTOMER_API_VERSION)
                        .description("This API provides endpoints to manage CUSTOMER data, including creating, retrieving, updating, and deleting CUSTOMER profiles. It ensures secure and efficient handling of CUSTOMER information."));
    }
}