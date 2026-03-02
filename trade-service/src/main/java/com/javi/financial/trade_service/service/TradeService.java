package com.javi.financial.trade_service.service;

import com.javi.financial.trade_service.client.PricingClient;
import com.javi.financial.trade_service.model.Trade;
import com.javi.financial.trade_service.repository.TradeRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class TradeService {

    private final TradeRepository repository;
    private final PricingClient pricingClient;

    public TradeService(TradeRepository repository,
                        PricingClient pricingClient) {
        this.repository = repository;
        this.pricingClient = pricingClient;
    }

    public Trade createTrade(String symbol, Integer quantity) {

        BigDecimal price = pricingClient.getPrice(symbol);
        BigDecimal notional = price.multiply(BigDecimal.valueOf(quantity));

        Trade trade = new Trade();
        trade.setSymbol(symbol);
        trade.setQuantity(quantity);
        trade.setPrice(price);
        trade.setNotional(notional);

        return repository.save(trade);
    }
}
