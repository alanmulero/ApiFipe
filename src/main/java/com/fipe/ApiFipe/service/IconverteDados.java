package com.fipe.ApiFipe.service;

import java.util.List;

public interface IconverteDados {

    <T> T converteDados(String json, Class<T> classe);
    // generic de uma Lista
    <T>List<T> converteListDados(String json, Class<T> classe);
}
