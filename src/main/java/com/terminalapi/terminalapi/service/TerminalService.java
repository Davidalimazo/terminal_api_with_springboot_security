package com.terminalapi.terminalapi.service;

import com.terminalapi.terminalapi.entity.Terminal;
import com.terminalapi.terminalapi.model.TerminalModel;
import com.terminalapi.terminalapi.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TerminalService {
    private final TerminalRepository terminalRepository;

    @Autowired
    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    public List<Terminal> getTerminal() {
        return  terminalRepository.findAll();

    }

    public Terminal addNewTerminal(TerminalModel terminalModel) {
        Terminal terminalOptional = terminalRepository.findByTerminalId(terminalModel.getTerminalId());
        Terminal terminal = new Terminal();
        if (terminalOptional == null) {
            terminal.setTerminalId(terminalModel.getTerminalId());
            terminal.setAmount(terminalModel.getAmount());
            terminal.setPosDate(terminalModel.getPosDate());
            terminal.setResponse_code("00");
            terminal.setResponseMessage("successful");
            terminal.setRrn(terminalModel.getRrn());
            terminal.setTransDate(terminalModel.getTransDate());
            terminal.setStan(terminalModel.getStan());
            terminal.setSerialNumber(terminalModel.getSerialNumber());
            terminalRepository.save(terminal);
            return terminal;
        } else {
            return null;
        }
    }
}
