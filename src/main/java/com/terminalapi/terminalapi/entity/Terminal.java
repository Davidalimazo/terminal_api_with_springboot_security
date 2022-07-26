package com.terminalapi.terminalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String terminalId;
    private String stan;
    private String rrn;
    private String serialNumber;
    private Long posDate;
    private Long transDate;
    private BigDecimal amount;
    private String responseCode;
    private String responseMessage;
}