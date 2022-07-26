package com.terminalapi.terminalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalModel {
    private Long id;
    private String terminalId;
    private String stan;
    private String rrn;
    private String serialNumber;
    private Long posDate;
    private Long transDate;
    private BigDecimal amount;
    private String response_code;
    private String responseMessage;
}
