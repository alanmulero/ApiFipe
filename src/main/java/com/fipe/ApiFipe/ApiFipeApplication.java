package com.fipe.ApiFipe;

import com.fipe.ApiFipe.model.Marca;
import com.fipe.ApiFipe.model.Modelo;
import com.fipe.ApiFipe.model.Tipo;
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
		// START:

		Conexao conexao = new Conexao();
		var json = conexao.obterDados("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/");
		System.out.println(json);
		// Convertido em json
		ConverteDadosEmJson converteDadosEmJson = new ConverteDadosEmJson();
		Tipo tipo = converteDadosEmJson.converteDados(json, Tipo.class);
		System.out.println(tipo);

		Marca marca = converteDadosEmJson.converteDados(json, Marca.class);
		System.out.println(marca);

		json = conexao.obterDados("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos");
		Modelo modelo = converteDadosEmJson.converteDados(json, Modelo.class);
		System.out.println(modelo);
	}

}
