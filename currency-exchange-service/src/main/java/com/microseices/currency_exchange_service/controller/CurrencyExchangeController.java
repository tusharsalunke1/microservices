package com.microseices.currency_exchange_service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microseices.currency_exchange_service.dto.CurrencyExchange;
import com.microseices.currency_exchange_service.repo.Currencyrepo;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private Currencyrepo vCurrencyrepo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveCyrrency(@PathVariable String from,@PathVariable String to) {
//		CurrencyExchange currencyExchange = new  CurrencyExchange(1001L,from,to,BigDecimal.valueOf(500.00));
//		
		CurrencyExchange currencyExchange =vCurrencyrepo.findByFromAndTo(from, to);// new  CurrencyExchange(1001L,from,to,BigDecimal.valueOf(500.00));

		currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
//		//vCurrencyrepo.findAll();
		return currencyExchange;
	}
}
