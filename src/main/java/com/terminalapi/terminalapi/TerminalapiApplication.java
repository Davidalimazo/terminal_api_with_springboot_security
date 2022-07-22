package com.terminalapi.terminalapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TerminalapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerminalapiApplication.class, args);
	}

}
