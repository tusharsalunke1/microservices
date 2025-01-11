package com.microseices.currency_conversion_service.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name="currency-exchange",url = "localhost:8000")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrenConversion retriveCyrrency(@PathVariable String from,@PathVariable String to);
	
}
