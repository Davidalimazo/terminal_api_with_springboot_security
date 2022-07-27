package com.terminalapi.terminalapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalModel {
    private Long id;
    private String terminalId;
    private String stan;
    private String rrn;
    private String serialNumber;
    private LocalDate posDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime transDate;
    private BigDecimal amount;
    private String response_code;
    private String responseMessage;
    private String maskPan;
    private String pmNumber;
    private String noticeReceiver;
    private String transType;
}
