package com.integrador.services;

import com.integrador.model.classes.Chat;
import com.integrador.model.classes.Mensagem;

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
    Call<Mensagem> adicionar(@Body Mensagem p);

    @GET("mensagem/")
    Call<List<Mensagem>> listar();

    @GET("mensagem/id/{id}")
    Call<Mensagem> buscarPorId(@Path("id") Long id);

    @DELETE("mensagem/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("mensagem/")
    Call<Mensagem> atualizar(@Body Mensagem p);

    @GET("mensagem/chat")
    Call<List<Mensagem>> buscarPorChat(@Body Chat chat);
}
