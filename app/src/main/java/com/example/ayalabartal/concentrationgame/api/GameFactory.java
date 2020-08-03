package com.example.ayalabartal.concentrationgame.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter.Factory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class GameFactory {

   public static ServerGameApi createGameApi(String apiURL){
       GsonConverterFactory jsonConverter = GsonConverterFactory.create();
       Retrofit retrofit = createRetrofit(apiURL, jsonConverter);
       ServerGameApi serverGameApi = retrofit.create(ServerGameApi.class);
       return serverGameApi;
   }

    private static Retrofit createRetrofit(String apiUrl, Factory  jsonConverter){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(apiUrl);
        builder.client(getRequestHeader());
        builder.addConverterFactory(ScalarsConverterFactory.create());
        builder.addConverterFactory(jsonConverter);
        return builder.build();
    }

    private static OkHttpClient getRequestHeader (){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.MINUTES);
        builder.readTimeout(60, TimeUnit.MINUTES);
        builder.writeTimeout(60, TimeUnit.MINUTES);
        OkHttpClient httpClient = builder.build();
        return httpClient;
    }
}
