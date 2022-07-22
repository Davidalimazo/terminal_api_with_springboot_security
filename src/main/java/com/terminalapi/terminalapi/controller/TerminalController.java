package com.terminalapi.terminalapi.controller;

import com.terminalapi.terminalapi.model.TerminalModel;
import com.terminalapi.terminalapi.response.BaseResponse;
import com.terminalapi.terminalapi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;

@RestController
public class TerminalController {
    private final TerminalService terminalService;
    @Autowired
    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @PostMapping("/terminalresponse")
    public ResponseEntity<?> terminalResponse(@RequestBody TerminalModel terminalModel){
        if(terminalService.addNewTerminal(terminalModel) != null){
            BaseResponse baseResponse = new BaseResponse();

            baseResponse.setTerminalId(terminalModel.getTerminalId());
            baseResponse.setAmount(terminalModel.getAmount());
            baseResponse.setResponse_code(terminalModel.getResponse_code());
            baseResponse.setResponseMessage(terminalModel.getResponseMessage());
            baseResponse.setRrn(terminalModel.getRrn());
            baseResponse.setStan(terminalModel.getStan());
            baseResponse.setSerialNumber(terminalModel.getSerialNumber());
            baseResponse.setPosDate(terminalModel.getPosDate());
            baseResponse.setTransDate(terminalModel.getTransDate());

            return ResponseEntity.ok(baseResponse);
        }
        return ResponseEntity.status(500).body("Terminal already exist");
    }
}