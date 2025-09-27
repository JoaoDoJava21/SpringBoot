package com.entendendoclasseapp.classeapplication;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {

		// SpringApplication.run(Application.class, args);


		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);

		builder.bannerMode(Banner.Mode.LOG); // Para retirar os baners em off

		//builder.profiles("producao" , "homologacao"); // Ele mostra os perfis que estão seguindo a aplicação e estão ativos

		builder.run(args); // Para rodar a aplicação . Sempre estando acima dos contextos por exemplo




		//ConfigurableApplicationContext applicationContext = builder.context();

		// var produtoRepository  = applicationContext.getBean("produtoRepository");



		// builder.profiles("spring.datasource.url=jdbc//");


		// Ele exibe o nome da aplicação
		//ConfigurableEnvironment enviroment = applicationContext.getEnvironment();
		//String applicationName = enviroment.getProperty("spring.application.name");
		//System.out.println("Nome da aplicaçao: " + applicationName);




	}

}
