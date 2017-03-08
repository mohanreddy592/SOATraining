package com.spring.cloud.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.model.TollUsage;
import com.spring.cloud.service.ITollService;

@RestController
public class TollRestAPI {

	@Autowired
	private ITollService iTollService;

	@RequestMapping("/tolls")
	public List<TollUsage> getAllTolls() {
		return iTollService.findAllTolls();
	}

	@RequestMapping("/tolls/{id}")
	public TollUsage getTollById(@PathVariable("id") String id) {
		return iTollService.findTollById(id);
	}

}
