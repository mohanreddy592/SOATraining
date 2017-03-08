package com.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class CustomLoadBalancer {

	@Autowired
	private IClientConfig iClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig iClientConfig) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig iClientConfig) {
		return new AvailabilityFilteringRule();
	}
}
