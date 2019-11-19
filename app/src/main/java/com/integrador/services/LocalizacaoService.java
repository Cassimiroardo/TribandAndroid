package com.integrador.services;

import com.integrador.model.classes.Localizacao;

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
    Call<Localizacao> adicionar(@Body Localizacao p);

    @GET("localizacao/")
    Call<List<Localizacao>> listar();

    @GET("localizacao/id/{id}")
    Call<Localizacao> buscarPorId(@Path("id") Long id);

    @DELETE("localizacao/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("localizacao/")
    Call<Localizacao> atualizar(@Body Localizacao p);

}
