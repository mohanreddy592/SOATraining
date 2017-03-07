package com.spring.cloud.repo;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.cloud.model.TollUsage;

@FeignClient("tollusagems")
public interface TollUsageFeignMSRepo {

	@RequestMapping("/tolls")
	public List<TollUsage> findAllTolls();

	@RequestMapping("/tolls/{id}")
	public TollUsage findTollById(@PathVariable("id") String id);

}
