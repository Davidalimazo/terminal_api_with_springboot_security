package com.terminalapi.terminalapi.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private String response_code;
    private String responseMessage;
}