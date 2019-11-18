package com.integrador.services;

import com.integrador.model.classes.Banda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AvaliacaoBandaService {
    @POST("avaliacaoBanda/")
    Call<AvaliacaoBandaService> adicionar(@Body AvaliacaoBandaService p);

    @GET("avaliacaoBanda/")
    Call<List<AvaliacaoBandaService>> listar();

    @GET("avaliacaoBanda/id/{id}")
    Call<AvaliacaoBandaService> buscarPorId(@Path("id") Long id);

    @DELETE("avaliacaoBanda/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("avaliacaoBanda/")
    Call<AvaliacaoBandaService> atualizar(@Body AvaliacaoBandaService p);


    @GET("avaliacaoBanda/buscaPorBanda")
    Call<List<AvaliacaoBandaService>> buscarPorBanda(@Body Banda banda);

}
