package com.microseices.micro_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microseices.micro_test.config.ConfigurationForProp;
import com.microseices.micro_test.dto.Limits;

@RestController
public class MicroTestController {
	
	@Autowired
	ConfigurationForProp tConfigurationForProp;
	@GetMapping("/getLimitsFromTest")
	public Limits retriveLimmits() {
		return new Limits(tConfigurationForProp.getMinimum(),tConfigurationForProp.getMaximum());
	}

}
