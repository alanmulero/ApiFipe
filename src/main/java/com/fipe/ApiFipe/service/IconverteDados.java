package com.fipe.ApiFipe.service;

public interface IconverteDados {

    <T> T converteDados(String json, Class<T> classe);
}
