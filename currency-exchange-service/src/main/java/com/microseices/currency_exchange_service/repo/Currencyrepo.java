package com.microseices.currency_exchange_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microseices.currency_exchange_service.dto.CurrencyExchange;

public interface Currencyrepo extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from,String to);
}
