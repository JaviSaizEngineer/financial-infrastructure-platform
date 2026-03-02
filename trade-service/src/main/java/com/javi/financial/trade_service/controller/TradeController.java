package com.javi.financial.trade_service.controller;

import com.javi.financial.trade_service.model.Trade;
import com.javi.financial.trade_service.service.TradeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public Trade create(@RequestParam String symbol,
                        @RequestParam Integer quantity) {
        return tradeService.createTrade(symbol, quantity);
    }
}