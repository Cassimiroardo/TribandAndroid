package com.integrador.services;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface Chat {



    @GET("estudio")
    Call<List<Chat>> buscarPorEstudio(@Body Estudio estudio);

    @GET("banda")
    Call<List<Chat>> buscarPorBanda(@Body Banda banda);

}
