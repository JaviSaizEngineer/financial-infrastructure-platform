package com.javi.financial.trade_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.javi.financial.trade_service.repository")
@EntityScan(basePackages = "com.javi.financial.trade_service.model")
public class TradeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeServiceApplication.class, args);
	}
}