package com.microseices.currency_conversion_service.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProy currencyExchangeProy;
	
	//using resgttemplate
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenConversion calculateCurrencyConversion(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity ) {
		
		
		HashMap<String,String> uriVariables = new  HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrenConversion> responseEntity;
		try {
			responseEntity = new RestTemplate()
					.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
					CurrenConversion.class,uriVariables);
		} catch (RestClientException e) {
			throw new RuntimeException("currency-exchange service down");
		}
		CurrenConversion currenConversion = responseEntity.getBody();
		
		if(currenConversion == null) {
			throw new RuntimeException("currency-exchange service down");
		}
		
		return new CurrenConversion(currenConversion.getId(),from,to,quantity,
				currenConversion.getConversionMultiple(),
				quantity.multiply(currenConversion.getConversionMultiple())
				,currenConversion.getEnvironment()
				);
		//return new CurrenConversion(1001,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"");
	}
	//using feign client
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrenConversion calculateCurrencyConversionFeign(@PathVariable String from,
			@PathVariable String to,@PathVariable BigDecimal quantity ) {
		HashMap<String,String> uriVariables = new  HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

	
		CurrenConversion currenConversion = currencyExchangeProy.retriveCyrrency(from, to);
		
		if(currenConversion == null) {
			throw new RuntimeException("currency-exchange service down");
		}
		
		return new CurrenConversion(currenConversion.getId(),from,to,quantity,
				currenConversion.getConversionMultiple(),
				quantity.multiply(currenConversion.getConversionMultiple())
				,currenConversion.getEnvironment()
				);
		//return new CurrenConversion(1001,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"");
	}
}
