package com.terminalapi.terminalapi.controller;

import com.terminalapi.terminalapi.model.AgentModel;
import com.terminalapi.terminalapi.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AgentController {
    private final AgentService agentService;
    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }
    @GetMapping("/agent/{terminalId}")
    public ResponseEntity<?> getAgents(@PathVariable("terminalId") String terminalId){
        if(agentService.getAgentByTerminaId(terminalId) == null){
            return ResponseEntity.status(500).body(terminalId+" does not exist");
        }
        return ResponseEntity.ok(agentService.getAgentByTerminaId(terminalId));
    }
    @GetMapping("/test")
    public String test(){
        return "hello";
    }
    @PostMapping("/registeragent")
    public ResponseEntity<?> registerAgent(@RequestBody AgentModel agentModel){
        if (agentService.registerAgent(agentModel)) {
            return ResponseEntity.ok(agentService.getAgentByTerminaId(agentModel.getTerminalId()));
        }else {
            return ResponseEntity.status(500).body("Agent with "+agentModel.getTerminalId()+" terminalId already registered");
        }
    }
}
