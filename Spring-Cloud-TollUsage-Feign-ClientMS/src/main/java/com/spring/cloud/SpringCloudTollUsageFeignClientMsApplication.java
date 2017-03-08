package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RibbonClient(name = "LB1", configuration = CustomLoadBalancer.class)
public class SpringCloudTollUsageFeignClientMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTollUsageFeignClientMsApplication.class, args);
	}
}
