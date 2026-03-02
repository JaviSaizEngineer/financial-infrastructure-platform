package com.javi.financial.trade_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javi.financial.trade_service.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
