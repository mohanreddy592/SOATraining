package com.spring.cloud.service;

import java.util.List;

import com.spring.cloud.model.TollUsage;

public interface ITollService {

	public List<TollUsage> findAllTolls();

	public TollUsage findTollById(String id);
}
