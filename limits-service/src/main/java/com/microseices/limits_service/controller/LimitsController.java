package com.microseices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microseices.limits_service.bean.Limits;
import com.microseices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {
	
	@Autowired
	private Configuration tConfiguration;
	
	@GetMapping("/limits")
	public Limits retriveLimits() {
		//return new Limits(1,2000);
		return new Limits(tConfiguration.getMinimum(),tConfiguration.getMaximum());
	}

}
