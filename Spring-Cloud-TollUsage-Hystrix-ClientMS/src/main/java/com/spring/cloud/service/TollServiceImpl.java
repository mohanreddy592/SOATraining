package com.spring.cloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.model.TollUsage;
import com.spring.cloud.repo.TollUsageFeignMSRepo;

@Service
public class TollServiceImpl implements ITollService {

	@Autowired
	private TollUsageFeignMSRepo tollUsageFeignMSRepo;

	@Override
	@HystrixCommand(fallbackMethod = "listOfTollUsageFallback")
	public List<TollUsage> findAllTolls() {
		return tollUsageFeignMSRepo.findAllTolls();
	}

	@Override
	public TollUsage findTollById(String id) {
		return tollUsageFeignMSRepo.findTollById(id);
	}

	public List<TollUsage> listOfTollUsageFallback() {
		List<TollUsage> list = new ArrayList<>();
		list.add(new TollUsage("123", "S12", "AP05NK0987", "09:45"));
		list.add(new TollUsage("456", "S23", "KA56TS5467", "09:45"));
		list.add(new TollUsage("678", "S45", "TN67RD2341", "09:45"));
		list.add(new TollUsage("901", "S67", "AP34YU8976", "09:45"));
		return list;
	}
}
