package com.integrador.services;

import com.integrador.model.Banda;
import com.integrador.model.Chat;
import com.integrador.model.classes.Estudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ChatService {

    @POST("chat/")
    Call<Chat> adicionar(@Body Chat p);

    @GET("chat/")
    Call<List<Chat>> listar();

    @GET("chat/id/{id}")
    Call<Chat> buscarPorId(@Path("id") Long id);

    @DELETE("chat/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("chat/")
    Call<Chat> atualizar(@Body Chat p);

    @GET("chat/estudio")
    Call<List<Chat>> buscarPorEstudio(@Body Estudio estudio);

    @GET("chat/banda")
    Call<List<Chat>> buscarPorBanda(@Body Banda banda);

}
