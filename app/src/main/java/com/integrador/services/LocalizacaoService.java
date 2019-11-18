package com.integrador.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface LocalizacaoService {
    @POST("localizacao/")
    Call<LocalizacaoService> adicionar(@Body LocalizacaoService p);

    @GET("localizacao/")
    Call<List<LocalizacaoService>> listar();

    @GET("localizacao/id/{id}")
    Call<LocalizacaoService> buscarPorId(@Path("id") Long id);

    @DELETE("localizacao/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("localizacao/")
    Call<LocalizacaoService> atualizar(@Body LocalizacaoService p);

}
