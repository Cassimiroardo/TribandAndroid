package com.integrador.services;

import com.integrador.model.Banda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BandaService extends GenericService<Banda>{

    @GET("login/{email}/{senha}")
    Call<Banda> buscarPorEmailEsenha(@Path("email") String email,@Path("senha") String senha);

    @GET("nome/{nome}")
    Call<List<Banda>> buscarPorNome(@Path("nome") String nome);

    @GET("email/{email}")
    Call<Banda> buscarPorEmail(@Path("email") String email);
}
