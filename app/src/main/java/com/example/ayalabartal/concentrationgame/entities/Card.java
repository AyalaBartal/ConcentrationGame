package com.example.ayalabartal.concentrationgame.entities;


import android.view.View;
import android.widget.TextView;

public class Card {
    public int cardId;
    public int pairId;
    public String content;
    public TextView cardText;

    public Card(int cardId, int pairId, String content/*, String cardLayoutId*/){
        this.cardId = cardId;
        this.pairId = pairId;
        this.content = content;
    }
}
