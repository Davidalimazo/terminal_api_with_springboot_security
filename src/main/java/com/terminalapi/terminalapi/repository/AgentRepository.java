package com.terminalapi.terminalapi.repository;

import com.terminalapi.terminalapi.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    public Agent findByTerminalId(String terminalId);
}

