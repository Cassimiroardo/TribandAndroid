package com.integrador.services;

import com.integrador.model.classes.Servico;
import com.integrador.model.classes.SubServico;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SubServicoServicoService {
    @POST("subservico/")
    Call<SubServico> adicionar(@Body SubServico p);

    @GET("subservico/")
    Call<List<SubServico>> listar();

    @GET("subservico/id/{id}")
    Call<SubServico> buscarPorId(@Path("id") Long id);

    @DELETE("subservico/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("subservico/")
    Call<SubServico> atualizar(@Body SubServico p);

    @GET("subservico/servico")
    Call<List<SubServico>> buscarPorServico(@Body Servico servico);
}
