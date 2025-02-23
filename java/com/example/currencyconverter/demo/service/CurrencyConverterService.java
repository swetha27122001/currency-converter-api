package com.example.currencyconverter.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.currencyconverter.demo.dto.CurrencyConversionRequest;
import com.example.currencyconverter.demo.dto.CurrencyConversionResponse;

@Service
public class CurrencyConverterService {
	
	@Autowired
    private ExchangeRateService exchangeRateService;
	
	public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        Map<String, Double> rates = exchangeRateService.getExchangeRates(request.getFrom());
        
        if (!rates.containsKey(request.getTo())) {
            throw new IllegalArgumentException("Invalid target currency: " + request.getTo());
        }

        double convertedAmount = request.getAmount() * rates.get(request.getTo());
        return new CurrencyConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }

}
