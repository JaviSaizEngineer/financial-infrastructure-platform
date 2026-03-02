package com.javi.financial.trade_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class PricingClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getPrice(String symbol) {
        return restTemplate.getForObject(
                "http://pricing-service:8080/pricing/" + symbol,
                BigDecimal.class
        );
    }
}