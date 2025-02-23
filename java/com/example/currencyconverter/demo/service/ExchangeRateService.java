package com.example.currencyconverter.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateService {

	@Value("${exchange.rate.api.url}")
	private String apiUrl;

	private final RestTemplate restTemplate = new RestTemplate();

	public Map<String, Double> getExchangeRates(String baseCurrency) {
		String url = apiUrl + baseCurrency;
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);
		return (Map<String, Double>) response.get("rates");
	}
}
