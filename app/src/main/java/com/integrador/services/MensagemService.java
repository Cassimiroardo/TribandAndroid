package com.integrador.services;

import com.integrador.model.classes.Chat;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface MensagemService {

    @POST("mensagem/")
    Call<MensagemService> adicionar(@Body MensagemService p);

    @GET("mensagem/")
    Call<List<MensagemService>> listar();

    @GET("mensagem/id/{id}")
    Call<MensagemService> buscarPorId(@Path("id") Long id);

    @DELETE("mensagem/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("mensagem/")
    Call<MensagemService> atualizar(@Body MensagemService p);

    @GET("mensagem/chat")
    Call<List<MensagemService>> buscarPorChat(@Body Chat chat);
}
