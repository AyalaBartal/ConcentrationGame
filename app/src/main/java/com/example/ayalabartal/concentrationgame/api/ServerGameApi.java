package com.example.ayalabartal.concentrationgame.api;

import com.example.ayalabartal.concentrationgame.entities.Pair;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ServerGameApi {

    @GET("/Game/Ofer")
    Call<Collection<Pair>> getAll();
}
