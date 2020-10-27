package com.example.ayalabartal.concentrationgame.mainActivity;

import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Controller {

    String m_ip;
    @Inject
    ServerAdapter serverAdapter;

    @Inject
    public Controller(/*String m_ip*/){
//        this.m_ip = m_ip;
    }


    public List<Card> createNewGameRequest() {
        serverAdapter.getCardListFromServer();
        return serverAdapter.getCardListFromServer();
    }


    public TurnResult processRequest(TurnRequest request) {
        return serverAdapter.processRequest(request);
    }
}
