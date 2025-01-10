package com.fipe.ApiFipe;

import com.fipe.ApiFipe.service.Conexao;

import java.util.Scanner;

public class Principal {

    Conexao conexao = new Conexao();
    Scanner leitura = new Scanner(System.in);
    private int carro = 1;
    private int moto = 2;
    private int caminhao = 3;
    private int sair = 0;
    private String endereco;
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    public void menu(){
        while (sair != 1) {
            var opcao = """
                   *** Digite uma Opção valida***
                   1 - Para Carro
                   2 - Para Moto
                   3 - Para Caminhao
                   0 - Para Sair
                    """;
            System.out.println(opcao);
            System.out.println("Escolha sua alternativa");
            var resposta = leitura.nextInt();
            if(resposta == 1){
                endereco = URL_BASE + "carros/marcas";
                System.out.println("Escolha um modelo");

            } else if (resposta == 2) {
                endereco = URL_BASE + "motos/marcas";

            } else if (resposta == 3) {
                endereco = URL_BASE + "caminhoes/marcas";

            } else {
                System.out.println("Fim do programa.");
                sair = 0;
                System.exit(0);
            }
            // Conectando a uma Api:
            var json = conexao.obterDados(endereco);
            System.out.println(json);

        }





    }

}
