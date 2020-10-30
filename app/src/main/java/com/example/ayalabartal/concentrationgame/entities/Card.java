package com.example.ayalabartal.concentrationgame.entities;


import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class Card implements Serializable {
    private int cardId;
    private int pairId;
    private String content;
    private View cardView;
    private TextView cardText;

    public Card(int cardId, int pairId, String content/*, String cardLayoutId*/){
        this.cardId = cardId;
        this.pairId = pairId;
        this.content = content;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getPairId() {
        return pairId;
    }

    public void setPairId(int pairId) {
        this.pairId = pairId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public View getCardView() {
        return cardView;
    }

    public void setCardView(View cardView) {
        this.cardView = cardView;
    }

    public TextView getCardText() {
        return cardText;
    }

    public void setCardText(TextView cardText) {
        this.cardText = cardText;
    }

}
