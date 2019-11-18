package com.integrador.services;

import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface EstudioService {

    @POST("estudio/")
    Call<Estudio> adicionar(@Body Estudio estudio);

    @GET("estudio/")
    Call<List<Estudio>> listar();

    @GET("estudio/id/{id}")
    Call<Estudio> buscarPorId(@Path("id") Long id);

    @DELETE("estudio/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("estudio/")
    Call<Estudio> atualizar(@Body Estudio estudio);


    @GET("estudio/email/{email}")
    Call<Estudio> buscarPorEmail(@Path("email") String email);

    @GET("estudio/login/{email}/{senha}")
    Call<Estudio> buscarPorEmailEsenha(@Path("email") String email,@Path("senha") String senha);

    @GET("estudio/nome/{nome}")
    Call<List<Estudio>> buscarPorNome(@Path("nome") String nome);

    @GET("estudio/proximidade/{latitude}/{longitude}/{raio}")
    Call<List<Estudio>> buscarPorProximidade(@Path("latitude") Double latitude,@Path("longitude") Double longitude,@Path("raio") Double raio);

    @GET("estudio/localizacao")
    Call<List<Estudio>> buscarPorLocalizacao(@Body Localizacao localizacao);

    @GET("estudio/preco/{preco}")
    Call<List<Estudio>> buscarPorPreco(@Path("preco") Double preco);

    @GET("estudio/horarioDisponivel/{inicio}/{fim}")
    Call<List<Estudio>> buscarPorHorarioDisponivel(@Path("inicio") Time inicio,@Path("fim") Time fim);

    @GET("estudio/filtro/{latitude}/{longitude}/{raio}/{preco}/{inicio}/{fim}/{ordenacao}")
    Call<List<Estudio>> buscarPorFiltro(@Path("latitude") Double latitude,@Path("longitude") Double longitude,@Path("raio") Double raio,@Path("preco") Double preco,@Path("inicio") String inicio,@Path("fim") String fim,@Path("ordenacao") Integer ordenacao,@Body Localizacao localizacao);
}
