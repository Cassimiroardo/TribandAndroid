package com.integrador.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface GenericService<P> {

    @POST("")
    Call<P> adicionar(@Body P p);

    @GET("")
    Call<List<P>> listar();

    @GET("id/{id}")
    Call<P> buscarPorId(@Path("id") Long id);

    @DELETE("id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("")
    Call<P> atualizar(@Body P p);


}
