package com.javi.financial.pricing_service.controller;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/pricing")
public class PricingController {

    private final Map<String, BigDecimal> prices = Map.of(
            "AAPL", new BigDecimal("180"),
            "TSLA", new BigDecimal("250"),
            "GOOG", new BigDecimal("130")
    );

    @GetMapping("/{symbol}")
    public BigDecimal getPrice(@PathVariable String symbol) {
        return prices.getOrDefault(symbol, BigDecimal.ZERO);
    }
}