package com.fipe.ApiFipe.model;

import com.fipe.ApiFipe.service.ConverteDadosEmJson;

import java.util.List;
import java.util.Scanner;

public class EscolheModelo {

    Scanner scanner = new Scanner(System.in);
    ConverteDadosEmJson conversor = new ConverteDadosEmJson();

    public String  nomeModelo(String endereco){
        System.out.println("Digite o código de uma marca para busca.");
        var resposta = scanner.nextLine();
        String modeloEscolhido = endereco +"/"+ resposta + "/modelos/";
        System.out.println(modeloEscolhido);
        return modeloEscolhido;
    }



}
