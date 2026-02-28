package com.javi.financial.collateral_service.controller;

import com.javi.financial.collateral_service.model.Collateral;
import com.javi.financial.collateral_service.repository.CollateralRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collateral")
@RequiredArgsConstructor
public class CollateralController {

    private final CollateralRepository repository;

    @PostMapping
    public Collateral create(@RequestBody Collateral collateral) {
        return repository.save(collateral);
    }

    @GetMapping
    public List<Collateral> findAll() {
        return repository.findAll();
    }
}
