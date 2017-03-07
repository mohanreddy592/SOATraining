package com.spring.cloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.model.TollUsage;
import com.spring.cloud.repo.TollRepository;

@RestController
public class TollService {

	@Autowired
	private TollRepository tollRepository;

	@RequestMapping(value = "/tolls", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TollUsage> findAllTolls() {
		return tollRepository.findAll();
	}

	@RequestMapping(value = "/tolls/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TollUsage findByTollId(@PathVariable("id") String tollId) {
		return tollRepository.findOne(tollId);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TollUsage> saveToll(@RequestBody TollUsage tollUsage) {
		return new ResponseEntity<TollUsage>(tollRepository.save(tollUsage), HttpStatus.CREATED);
	}

}
