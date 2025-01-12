package com.i2i.ssa.api.cart.config;

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
    public static final String CART_API             = "Cart API";
    public static final String CART_API_TITLE       = "Cart API";
    public static final String CART_API_VERSION     = "0.0.1";
    public static final String CART_API_TAG         = "cart-controller";


    private Tag createTag(String name) {
        return new Tag().name(name);
    }

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title(CART_API_TITLE)
                        .version(CART_API_VERSION)
                        .description("This API allows clients to manage shopping carts by providing endpoints to create, retrieve, update, and delete cart items. It supports operations such as adding products, updating quantities, and calculating the total price."));
    }
}