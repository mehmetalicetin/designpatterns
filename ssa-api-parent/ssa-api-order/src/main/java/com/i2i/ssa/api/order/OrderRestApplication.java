package com.i2i.ssa.api.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.i2i.ssa.api.client")
public class OrderRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderRestApplication.class, args);
	}

}
