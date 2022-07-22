package com.terminalapi.terminalapi.service;

import com.terminalapi.terminalapi.entity.Agent;
import com.terminalapi.terminalapi.model.AgentModel;
import com.terminalapi.terminalapi.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final AgentRepository agentRepository;
    @Autowired
    public AgentService( AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }
    public Agent getAgentByTerminaId(String terminalId){
        Agent agent = agentRepository.findByTerminalId(terminalId);
        if (agent ==null) {
            return null;
        }
        return agent;
    }
    public boolean registerAgent(AgentModel agentModel){
        Agent agent = agentRepository.findByTerminalId(agentModel.getTerminalId());
        if(agent == null){
            Agent newAgent = new Agent();
            newAgent.setTerminalId(agentModel.getTerminalId());
            newAgent.setBalance(agentModel.getBalance());
            newAgent.setRrn(agentModel.getRrn());
            newAgent.setRegistrationDate(agentModel.getRegistrationDate());
            newAgent.setStan(agentModel.getStan());
            newAgent.setSerialNumber(agentModel.getSerialNumber());
            newAgent.setPassword(passwordEncoder.encode(agentModel.getPassword()));
            agentRepository.save(newAgent);
            return true;
        }else return false;
    }

}