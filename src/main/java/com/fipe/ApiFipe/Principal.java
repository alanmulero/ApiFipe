package com.fipe.ApiFipe;

import com.fipe.ApiFipe.model.Dados;
import com.fipe.ApiFipe.model.EscolheModelo;
import com.fipe.ApiFipe.model.Modelo;
import com.fipe.ApiFipe.service.Conexao;
import com.fipe.ApiFipe.service.ConverteDadosEmJson;

import java.util.Comparator;
import java.util.Scanner;

public class Principal {

    Conexao conexao = new Conexao();
    ConverteDadosEmJson conversor = new ConverteDadosEmJson();
    Scanner leitura = new Scanner(System.in);
    EscolheModelo escolheModelo = new EscolheModelo();
    private int carro = 1;
    private int moto = 2;
    private int caminhao = 3;
    private String endereco;
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void menu() {

        var opcao = """
                *** Digite uma Opção valida***
                1 - Para Carro
                2 - Para Moto
                3 - Para Caminhao
                0 - Para Sair
                """;
        System.out.println(opcao);
        System.out.println("Escolha sua alternativa");
        try {
            var resposta = leitura.nextInt();
            if (resposta == 1) {
                endereco = URL_BASE + "carros/marcas";

            } else if (resposta == 2) {
                endereco = URL_BASE + "motos/marcas";

            } else if (resposta == 3) {
                endereco = URL_BASE + "caminhoes/marcas";

            } else {
                System.out.println("Fim do programa.");
                System.exit(0);
            }
        } catch (RuntimeException e) {
            System.out.println("Entrada inválida! Digite um número de 1 até 3, ou 0 para sair. => " + e.getMessage());
        }
        // Conectando a uma Api:
        var json = conexao.obterDados(endereco);
        //System.out.println(json);
        var marcas = conversor.converteListDados(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        // Modelo:
        var endereco2 = escolheModelo.nomeModelo(endereco);
        json = conexao.obterDados(endereco2);
        var modeloLista = conversor.converteDados(json, Modelo.class);
        System.out.println("Modelos da marca escolhida: ");
        System.out.println();
        modeloLista.modelos().stream() // Referenciando na classe Modelos uma instancia da lista de Dados com modelos()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);


    }


}


