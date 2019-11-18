package com.integrador.services;

import com.integrador.model.Banda;
import com.integrador.model.Estudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservaService {
    @POST("reserva/")
    Call<ReservaService> adicionar(@Body ReservaService p);

    @GET("reserva/")
    Call<List<ReservaService>> listar();

    @GET("reserva/id/{id}")
    Call<ReservaService> buscarPorId(@Path("id") Long id);

    @DELETE("reserva/id/{id}")
    Call<Void> deletar(@Path("id") Long id);

    @PUT("reserva/")
    Call<ReservaService> atualizar(@Body ReservaService p);

    @GET("reserva/banda")
    Call<List<ReservaService>> buscarPorBanda(@Body Banda banda);

    @GET("reserva/estudio")
    Call<List<ReservaService>> buscarPorEstudio(@Body Estudio estudio);

    @GET("reserva/estudio/{data}")
    Call<List<ReservaService>> buscarPorEstudioEData(@Body Estudio estudio, @Path("data") String data);
}
