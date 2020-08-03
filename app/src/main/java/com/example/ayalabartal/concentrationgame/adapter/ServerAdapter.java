package com.example.ayalabartal.concentrationgame.adapter;

import android.util.Log;

import com.example.ayalabartal.concentrationgame.api.GameFactory;
import com.example.ayalabartal.concentrationgame.api.ServerGameApi;
import com.example.ayalabartal.concentrationgame.entities.Pair;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ServerAdapter {

    private String m_ip;

    public ServerAdapter(String m_ip){
        this.m_ip = m_ip;
        getCardListFromServer();
    }

    private void getCardListFromServer() {
        ServerGameApi serverApi = GameFactory.createGameApi(m_ip);
        Call<Collection<Pair>> callBack = serverApi.getAll();
        callBack.enqueue(getPairListCallBack());
    }

    private Callback<Collection<Pair>> getPairListCallBack() {
        Callback<Collection<Pair>> result = new Callback<Collection<Pair>>() {
            @Override
            public void onResponse(Call<Collection<Pair>> call, Response<Collection<Pair>> response) {
                List<Pair> pairList = (List)response.body();
            }

            @Override
            public void onFailure(Call<Collection<Pair>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        };
        return result;
    }
}
