package com.integrador.services;

import com.integrador.model.classes.Estudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServicoService {
    @POST("servico/")
    Call<ServicoService> adicionar(@Body ServicoService p);

    @GET("servico/")
    Call<List<ServicoService>> listar();

    @GET("servico/id/{id}")
    Call<ServicoService> buscarPorId(@Path("id") Long id);

    @DELETE("servico/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("servico/")
    Call<ServicoService> atualizar(@Body ServicoService p);

    @GET("servico/estudio")
    Call<List<ServicoService>> buscarPorEstudio(@Body Estudio estudio);
}
