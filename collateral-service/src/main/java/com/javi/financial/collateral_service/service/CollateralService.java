package com.javi.financial.collateral_service.service;

import com.javi.financial.collateral_service.model.Collateral;
import com.javi.financial.collateral_service.repository.CollateralRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CollateralService {

    private final CollateralRepository repository;

    private static final BigDecimal MARGIN_RATE = new BigDecimal("0.10");

    public CollateralService(CollateralRepository repository) {
        this.repository = repository;
    }

    public Collateral evaluate(String accountId,
                               BigDecimal exposure,
                               BigDecimal collateralAmount) {

        BigDecimal marginRequired = exposure.multiply(MARGIN_RATE);

        String status;

        if (collateralAmount.compareTo(marginRequired) >= 0) {
            status = "OK";
        } else if (collateralAmount.compareTo(marginRequired.multiply(new BigDecimal("0.5"))) >= 0) {
            status = "MARGIN_CALL";
        } else {
            status = "BREACH";
        }

        Collateral collateral = new Collateral();
        collateral.setAccountId(accountId);
        collateral.setExposure(exposure);
        collateral.setMarginRequired(marginRequired);
        collateral.setCollateralAmount(collateralAmount);
        collateral.setStatus(status);

        return repository.save(collateral);
    }
}