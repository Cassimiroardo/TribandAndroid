package com.integrador.Triband;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FilmeService {

    @POST("filmes")
    Call<Filme> adicionar(@Body Filme filme);

    @GET("filmes")
    Call<List<Filme>> listarFilmes();

    @DELETE("filmes/{id}")
    Call<Void> deletar(@Path("id") Integer id);

    @PUT("filmes")
    Call<Filme> atualizar(@Body Filme filme);






}
