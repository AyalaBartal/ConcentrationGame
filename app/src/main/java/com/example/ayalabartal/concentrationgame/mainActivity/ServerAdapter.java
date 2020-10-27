package com.example.ayalabartal.concentrationgame.mainActivity;

import com.example.ayalabartal.concentrationgame.backEnd.BackEnd;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ServerAdapter {

    private BackEnd backEnd;

    @Inject
    public ServerAdapter(){
/*        this.m_ip = IP.getIp();
        getCardListFromServer();*/
    }

    List<Card> getCardListFromServer() {
        backEnd = new BackEnd();
        return backEnd.createGame();
        /*ServerGameApi serverApi = GameFactory.createGameApi(IP.ip);
        Call<Collection<Pair>> callBack = serverApi.getAll();
        callBack.enqueue(getPairListCallBack());*/

    }

    public TurnResult processRequest(TurnRequest request) {
        return backEnd.processTurn(request);
    }



   /* private Callback<Collection<Pair>> getPairListCallBack() {
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
    }*/
}
