package com.fipe.ApiFipe;

import com.fipe.ApiFipe.model.Dados;
import com.fipe.ApiFipe.service.Conexao;
import com.fipe.ApiFipe.service.ConverteDadosEmJson;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    Conexao conexao = new Conexao();
    ConverteDadosEmJson conversor = new ConverteDadosEmJson();
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
            try{
            var resposta = leitura.nextInt();
            if(resposta == 1){
                endereco = URL_BASE + "carros/marcas";


            } else if (resposta == 2) {
                endereco = URL_BASE + "motos/marcas";

            } else if (resposta == 3) {
                endereco = URL_BASE + "caminhoes/marcas";

            } else {
                System.out.println("Fim do programa.");
                sair = 0;
                System.exit(0);
            }
            } catch (RuntimeException e) {
                System.out.println("Entrada inválida! Digite um número de 1 até 3, ou 0 para sair. => " + e.getMessage());
            }
            // Conectando a uma Api:
            var json = conexao.obterDados(endereco);
            System.out.println(json);
            var marcas = conversor.converteListDados(json, Dados.class);
            marcas.stream()
                    .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);





        }

//         Método para escolha do modelo:
//        public  static void modelo(){
//            var escolhaModelo = """
//                    Digite o número de um codigo para escolher o modelo.
//                    """;
//            System.out.println(escolhaModelo);
//            System.out.println("Escolha um modelo: ");
//            var respostaModelo = leitura.nextLine();
//            System.out.println(respostaModelo);
//        }





    }

}
