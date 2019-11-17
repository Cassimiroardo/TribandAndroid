package com.integrador.services;

import com.integrador.model.Estudio;
import com.integrador.model.Localizacao;

import java.sql.Time;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EstudioService extends GenericService<Estudio> {

    @GET("email/{email}")
    Call<Estudio> buscarPorEmail(@Path("email") String email);

    @GET("login/{email}/{senha}")
    Call<Estudio> buscarPorEmailEsenha(@Path("email") String email,@Path("senha") String senha);

    @GET("nome/{nome}")
    Call<List<Estudio>> buscarPorNome(@Path("nome") String nome);

    @GET("proximidade/{latitude}/{longitude}/{raio}")
    Call<List<Estudio>> buscarPorProximidade(@Path("latitude") Double latitude,@Path("longitude") Double longitude,@Path("raio") Double raio);

    @GET("localizacao")
    Call<List<Estudio>> buscarPorLocalizacao(@Body Localizacao localizacao);

    @GET("preco/{preco}")
    Call<List<Estudio>> buscarPorPreco(@Path("preco") Double preco);

    @GET("horarioDisponivel/{inicio}/{fim}")
    Call<List<Estudio>> buscarPorHorarioDisponivel(@Path("inicio") Time inicio,@Path("fim") Time fim);

    @GET("filtro/{latitude}/{longitude}/{raio}/{preco}/{inicio}/{fim}/{ordenacao}")
    Call<List<Estudio>> buscarPorFiltro(@Path("latitude") Double latitude,@Path("longitude") Double longitude,@Path("raio") Double raio,@Path("preco") Double preco,@Path("inicio") Time inicio,@Path("fim") Time fim,@Path("ordenacao") Integer ordenacao);
}
