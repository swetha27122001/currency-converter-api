package com.example.currencyconverter.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.currencyconverter.demo.dto.CurrencyConversionRequest;
import com.example.currencyconverter.demo.dto.CurrencyConversionResponse;
import com.example.currencyconverter.demo.service.CurrencyConverterService;
import com.example.currencyconverter.demo.service.ExchangeRateService;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {
	
	@Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private CurrencyConverterService currencyConverterService;
    
    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return exchangeRateService.getExchangeRates(base);
    }
    
    @PostMapping("/convert")
    public CurrencyConversionResponse convertCurrency(@RequestBody CurrencyConversionRequest request) {
        return currencyConverterService.convertCurrency(request);
    }

}
