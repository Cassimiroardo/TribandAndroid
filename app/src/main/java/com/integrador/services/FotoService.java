package com.integrador.services;

import com.integrador.model.Foto;

import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface FotoService {
    @Multipart
    @POST("foto/")
    Call<Foto> adiciona(@Part Multipart foto);
}
