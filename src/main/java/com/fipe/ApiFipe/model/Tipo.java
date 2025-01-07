package com.fipe.ApiFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Tipo(@JsonAlias("TipoVeiculo") String TipoDeVeiculo) {

}
