package com.terminalapi.terminalapi.controller;

import com.terminalapi.terminalapi.entity.Terminal;
import com.terminalapi.terminalapi.model.TerminalModel;
import com.terminalapi.terminalapi.response.BaseResponse;
import com.terminalapi.terminalapi.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.util.List;
//@CrossOrigin(origins = "*")
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
            baseResponse.setResponse_code(terminalModel.getResponseCode());
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
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String user, String password){

        return ResponseEntity.status(200).body("login successful");
    }
    @GetMapping("/list")
    public List<Terminal> getTerminalList(){
        return terminalService.getTerminalList();
    }
    @GetMapping("/response/{code}")
    public List<Terminal> getTerminalResponse(@PathVariable("code") String code){
        return terminalService.getTerminalByResponseCode(code);
    }
    @GetMapping("/search/{value}")
    public List<Terminal> getSearches(@PathVariable("value") String value){
        return terminalService.getBySearch(value);
    }
}