package com.terminalapi.terminalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentModel {
    private Long id;
    private String terminalId;
    private String stan;
    private String serialNumber;
    private String rrn;
    private String password;
    private LocalDate registrationDate;
    private BigDecimal balance;
    private String role="ROLE_USER";

}