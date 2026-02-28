package com.javi.financial.collateral_service.repository;

import com.javi.financial.collateral_service.model.Collateral;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollateralRepository
        extends JpaRepository<Collateral, Long> {
}