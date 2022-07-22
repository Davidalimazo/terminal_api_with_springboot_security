package com.terminalapi.terminalapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
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