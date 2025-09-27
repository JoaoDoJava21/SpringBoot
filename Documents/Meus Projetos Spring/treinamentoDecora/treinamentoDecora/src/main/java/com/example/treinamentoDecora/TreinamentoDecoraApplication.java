package com.example.treinamentoDecora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TreinamentoDecoraApplication {


	@GetMapping
	public String welcome(){
		return "Welcome User";
	}

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoDecoraApplication.class, args);
	}

}
