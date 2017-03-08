package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class SpringCloudOrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOrderMsApplication.class, args);
	}

	@Bean
	public Docket newApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tollusagems").apiInfo(apiInfo()).select()
				.paths(PathSelectors.regex("/tolls.*|/save.*")).build();
	}

	private ApiInfo apiInfo() {

		return new ApiInfoBuilder().title("Toll Usage MS").description("Toll Usage Micro Service")
				.termsOfServiceUrl("http://sg.com").contact("Ram").license("XYZ License").version("3.0").build();
	}
}
