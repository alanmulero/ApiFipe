package com.fipe.ApiFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


public record Modelo(String codigo, String nome) {
}
