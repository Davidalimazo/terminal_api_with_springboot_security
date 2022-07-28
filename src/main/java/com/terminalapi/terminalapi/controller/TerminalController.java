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

@RestController
@RequestMapping("/api/terminal-request")
public class TerminalController {
    @Autowired
    TerminalService terminalService;

    @PostMapping
    public ResponseEntity<?> postRequest(@RequestBody TerminalModel terminalModel){
        BaseResponse baseResponse = new BaseResponse();

        if(terminalService.addNewTerminal(terminalModel) != null){
            if (terminalModel.getResponse_code().equals("00")) {
                baseResponse.setResponse_code("00");
                baseResponse.setResponseMessage("APPROVED TRANSACTION SAVED SUCCESSFULLY");
                return ResponseEntity.ok(baseResponse);
            }

            baseResponse.setResponse_code("01");
            baseResponse.setResponseMessage("FAILED TRANSACTION SAVED SUCCESSFULLY");
            return ResponseEntity.status(500).body(baseResponse);
        }
        baseResponse.setResponse_code("01");
        baseResponse.setResponseMessage("ERROR OCCURRED WHILE SAVING TRANSACTION AS A COPY OF THE TRANSACTION ALREADY EXIST");
        return ResponseEntity.status(500).body(baseResponse);
    }
    @GetMapping
    public List<Terminal> getRequest(){
        return terminalService.getTerminal();
    }
}