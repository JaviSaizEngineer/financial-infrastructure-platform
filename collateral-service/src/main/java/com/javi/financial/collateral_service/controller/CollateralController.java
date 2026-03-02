package com.javi.financial.collateral_service.controller;

import com.javi.financial.collateral_service.model.Collateral;
import com.javi.financial.collateral_service.repository.CollateralRepository;
import com.javi.financial.collateral_service.service.CollateralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/collateral")
public class CollateralController {

    private final CollateralService service;

    public CollateralController(CollateralService service) {
        this.service = service;
    }

    @PostMapping("/evaluate")
    public Collateral evaluate(
            @RequestParam String accountId,
            @RequestParam BigDecimal exposure,
            @RequestParam BigDecimal collateralAmount) {

        return service.evaluate(accountId, exposure, collateralAmount);
    }
}
