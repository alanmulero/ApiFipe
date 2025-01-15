package com.fipe.ApiFipe;

import com.fipe.ApiFipe.model.Dados;
import com.fipe.ApiFipe.model.EscolheModelo;
import com.fipe.ApiFipe.model.Modelo;
import com.fipe.ApiFipe.model.Veiculo;
import com.fipe.ApiFipe.service.Conexao;
import com.fipe.ApiFipe.service.ConverteDadosEmJson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
                Carro
                Moto
                Caminhao
                0 - Para Sair
                """;
        System.out.println(opcao);
        System.out.println("Escolha sua alternativa");
        try {
            var resposta = leitura.nextLine();
            if (resposta.toLowerCase().contains("carro")) {
                endereco = URL_BASE + "carros/marcas";

            } else if (resposta.toLowerCase().contains("moto")) {
                endereco = URL_BASE + "motos/marcas";

            } else if (resposta.toLowerCase().contains("caminhao")) {
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

        // AnoModelo
        System.out.println();
        System.out.println("****************************************************************");
        System.out.println();
        System.out.println("\nDigite o nome do veiculo que quer ver listado: ");
        var veiculo = leitura.nextLine();
        List<Dados> anoModelo = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(veiculo.toLowerCase()))
                .collect(Collectors.toList());
        System.out.println("*****************************************************************");
        System.out.println("\nLista do nome do veiculo: ");
        anoModelo.forEach(System.out::println);

        // Escolhendo o ano
        System.out.println("Digite o código do modelo que quer ver listado: ");
        var codigo = leitura.nextLine();
        var endereco3 = endereco2 + codigo + "/anos/";
        json = conexao.obterDados(endereco3);
        List<Dados> codigoCarroAno = conversor.converteListDados(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < codigoCarroAno.size() ; i++) {
            var carroAno = endereco3 + codigoCarroAno.get(i).codigo() + "/";
            json = conexao.obterDados(carroAno);
            Veiculo novoVeiculo = conversor.converteDados(json, Veiculo.class);
            veiculos.add(novoVeiculo);
        }

        System.out.println("\nLista do veiculo com avaliação por ano: ");
        veiculos.forEach(System.out::println);




    }


}


