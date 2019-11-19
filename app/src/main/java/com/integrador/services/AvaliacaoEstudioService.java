package com.integrador.services;

import com.integrador.model.classes.AvaliacaoEstudio;
import com.integrador.model.classes.Estudio;

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
    Call<AvaliacaoEstudio> adicionar(@Body AvaliacaoEstudio p);

    @GET("avaliacaoEstudio/")
    Call<List<AvaliacaoEstudio>> listar();

    @GET("avaliacaoEstudio/id/{id}")
    Call<AvaliacaoEstudio> buscarPorId(@Path("id") Long id);

    @DELETE("avaliacaoEstudio/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("avaliacaoEstudio/")
    Call<AvaliacaoEstudio> atualizar(@Body AvaliacaoEstudio p);

    @GET("avaliacaoEstudio/buscaPorEstudio")
    Call<List<AvaliacaoEstudio>> buscaPorEstudio(@Body Estudio estudio);
}
