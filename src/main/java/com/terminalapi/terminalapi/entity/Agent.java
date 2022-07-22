package com.terminalapi.terminalapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String terminalId;
    private String stan;
    private String rrn;
    private String serialNumber;
    private LocalDate registrationDate;
    private BigDecimal balance;
    @Column( nullable = false)
    private String password;
    private String role="ROLE_USER";

}

