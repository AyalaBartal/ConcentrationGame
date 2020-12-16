package com.example.ayalabartal.concentrationgame.entities;


import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class Card implements Serializable {
    private final int pairId;
    private final String content;
    private TextView cardText;

    public Card(int pairId, String content){
        this.pairId = pairId;
        this.content = content;
    }

    public int getPairId() {
        return pairId;
    }

    public String getContent() {
        return content;
    }

    public TextView getCardText() {
        return cardText;
    }

    public void setCardText(TextView cardText) {
        this.cardText = cardText;
    }

}
