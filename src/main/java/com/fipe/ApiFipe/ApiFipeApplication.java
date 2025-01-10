package com.fipe.ApiFipe;

import com.fipe.ApiFipe.model.Dados;
import com.fipe.ApiFipe.service.Conexao;
import com.fipe.ApiFipe.service.ConverteDadosEmJson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiFipeApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {

	}

	public static void main(String[] args)  {
		SpringApplication.run(ApiFipeApplication.class, args);
		 //START:
		Principal principal = new Principal();
		principal.menu();






	}

}
