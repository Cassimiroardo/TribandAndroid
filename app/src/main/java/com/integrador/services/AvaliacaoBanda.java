package com.integrador.services;

import com.integrador.model.Banda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AvaliacaoBanda {
    @POST("avaliacaoBanda/")
    Call<AvaliacaoBanda> adicionar(@Body AvaliacaoBanda p);

    @GET("avaliacaoBanda/")
    Call<List<AvaliacaoBanda>> listar();

    @GET("avaliacaoBanda/id/{id}")
    Call<AvaliacaoBanda> buscarPorId(@Path("id") Long id);

    @DELETE("avaliacaoBanda/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("avaliacaoBanda/")
    Call<AvaliacaoBanda> atualizar(@Body AvaliacaoBanda p);


    @GET("avaliacaoBanda/buscaPorBanda")
    Call<List<AvaliacaoBanda>> buscarPorBanda(@Body Banda banda);

}
