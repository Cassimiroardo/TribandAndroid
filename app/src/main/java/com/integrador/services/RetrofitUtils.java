package com.integrador.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    // como utilizamos esse trecho de código em várias activities a cada mudança de IP
    // teríamos que alterar em todas as activities.
    // para melhorar a manutenibilidade do código criei essa classe RetrofitUtils
    // e reaproveitamos esse trecho em todas as activities;
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://url-aqui/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
