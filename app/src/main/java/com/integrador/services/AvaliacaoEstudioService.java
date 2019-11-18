package com.integrador.services;

import com.integrador.model.Estudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AvaliacaoEstudioService {
    @POST("avaliacaoEstudio/")
    Call<AvaliacaoEstudioService> adicionar(@Body AvaliacaoEstudioService p);

    @GET("avaliacaoEstudio/")
    Call<List<AvaliacaoEstudioService>> listar();

    @GET("avaliacaoEstudio/id/{id}")
    Call<AvaliacaoEstudioService> buscarPorId(@Path("id") Long id);

    @DELETE("avaliacaoEstudio/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("avaliacaoEstudio/")
    Call<AvaliacaoEstudioService> atualizar(@Body AvaliacaoEstudioService p);

    @GET("avaliacaoEstudio/buscaPorEstudio")
    Call<List<AvaliacaoEstudioService>> buscaPorEstudio(@Body Estudio estudio);
}
