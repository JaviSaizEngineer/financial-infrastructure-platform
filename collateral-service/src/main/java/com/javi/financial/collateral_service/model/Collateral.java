package com.javi.financial.collateral_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "collateral")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collateral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountId;
    private BigDecimal collateralAmount;
    private BigDecimal marginRequired;
    private BigDecimal exposure;
    private String status; // OK, MARGIN_CALL, BREACH

    // getters & setters
}