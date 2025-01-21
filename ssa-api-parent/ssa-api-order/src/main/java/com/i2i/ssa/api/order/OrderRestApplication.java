package com.i2i.ssa.api.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.i2i.ssa.api.client")
@EnableDiscoveryClient
public class OrderRestApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);
		return new RestTemplate(requestFactory);
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderRestApplication.class, args);
	}

}
