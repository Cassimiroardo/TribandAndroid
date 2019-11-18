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

public interface BandaService {

    @POST("banda/")
    Call<Banda> adicionar(@Body Banda p);

    @GET("banda/")
    Call<List<Banda>> listar();

    @GET("banda/id/{id}")
    Call<Banda> buscarPorId(@Path("id") Long id);

    @DELETE("banda/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("banda/")
    Call<Banda> atualizar(@Body Banda p);

    @GET("banda/login/{email}/{senha}")
    Call<Banda> buscarPorEmailEsenha(@Path("email") String email,@Path("senha") String senha);

    @GET("banda/nome/{nome}")
    Call<List<Banda>> buscarPorNome(@Path("nome") String nome);

    @GET("banda/email/{email}")
    Call<Banda> buscarPorEmail(@Path("email") String email);
}
