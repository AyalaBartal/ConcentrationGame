package com.example.ayalabartal.concentrationgame.concentrationGame;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.example.ayalabartal.concentrationgame.di.DaggerServerComponent;
import com.example.ayalabartal.concentrationgame.di.ExampleApp;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton

public class ConcentrationGameController {

    String m_ip;
    @Inject
    ServerAdapter serverAdapter;

    @Inject
    public ConcentrationGameController(){}

    public void createNewGame(Context context) {
        serverAdapter = ((ExampleApp) context.getApplicationContext()).getServerComponent().getServerAdapter();
        serverAdapter.getCardListFromServer();
        Intent intent = new Intent(context, ConcentrationGameActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Card List", (Serializable) serverAdapter.getCardListFromServer());
        intent.putExtra("Card List", bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    public TurnResult processRequest(TurnRequest request) {
        return serverAdapter.processRequest(request);
    }
}
