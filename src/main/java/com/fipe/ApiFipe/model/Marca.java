package com.fipe.ApiFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Marca(@JsonAlias("Marca") String MarcaDoVeiculo) {

}
