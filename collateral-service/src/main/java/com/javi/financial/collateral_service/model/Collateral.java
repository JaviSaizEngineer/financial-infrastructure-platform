package com.javi.financial.collateral_service.model;

import jakarta.persistence.*;
import lombok.*;

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

    private String counterparty;

    private Double amount;

    private String currency;
}