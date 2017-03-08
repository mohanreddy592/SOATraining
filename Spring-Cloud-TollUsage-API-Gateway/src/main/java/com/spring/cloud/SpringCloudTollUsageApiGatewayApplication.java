package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@CrossOrigin
public class SpringCloudTollUsageApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTollUsageApiGatewayApplication.class, args);
	}
}
