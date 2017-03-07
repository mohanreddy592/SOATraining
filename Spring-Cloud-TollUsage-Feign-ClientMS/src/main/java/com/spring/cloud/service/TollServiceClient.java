package com.spring.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.model.TollUsage;
import com.spring.cloud.repo.TollUsageFeignMSRepo;

@RestController
public class TollServiceClient {

	@Autowired
	private TollUsageFeignMSRepo tollUsageFeignMSRepo;

	@RequestMapping("/tolls")
	public List<TollUsage> getAllTolls() {
		return tollUsageFeignMSRepo.findAllTolls();
	}

	@RequestMapping("/tolls/{id}")
	public TollUsage getTollById(@PathVariable("id") String id) {
		return tollUsageFeignMSRepo.findTollById(id);
	}

}
