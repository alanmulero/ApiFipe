package com.fipe.ApiFipe.model;

import com.fipe.ApiFipe.service.ConverteDadosEmJson;

import java.util.Scanner;

public class EscolheModelo {

    Scanner scanner = new Scanner(System.in);
    ConverteDadosEmJson conversor = new ConverteDadosEmJson();

    public String  nomeModelo(String endereco){
        System.out.println("Digite o código de um veiculo para busca.");
        var resposta = scanner.nextLine();
        var modeloEscolhido = endereco +"/"+ resposta + "/modelos";
        System.out.println(modeloEscolhido);
        return modeloEscolhido;
    }
}
