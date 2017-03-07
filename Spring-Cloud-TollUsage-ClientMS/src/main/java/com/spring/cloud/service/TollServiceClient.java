package com.spring.cloud.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.model.TollUsage;

@RestController
public class TollServiceClient {

	private static final String TOLLUSAGEMS = "tollusagems";

	@Autowired
	private DiscoveryClient discoveryClient;

	private RestTemplate restTemplate = new RestTemplate();

	@SuppressWarnings("unchecked")
	@RequestMapping("/client")
	public List<TollUsage> findAllTolls() {
		List<ServiceInstance> instances = discoveryClient.getInstances(TOLLUSAGEMS);
		ServiceInstance instance = instances.get(0);
		URI uri = instance.getUri();
		List<TollUsage> tollUsages = null;
		try {
			tollUsages = (List<TollUsage>) restTemplate
					.getForEntity(new URI(uri.toString().concat("/tolls")), List.class).getBody();
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}

		return tollUsages;
	}
}
