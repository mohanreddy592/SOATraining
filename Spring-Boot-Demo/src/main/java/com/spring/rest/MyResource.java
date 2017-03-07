package com.spring.rest;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyResource {

	@RequestMapping(method = RequestMethod.GET, value = "/greet", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String greet() {
		return "Welcome to Spring Boot Application " + new Date();
	}
}
