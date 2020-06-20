package com.example.ayalabartal.concentrationgame.entities;

import com.example.ayalabartal.concentrationgame.entities.Card;

public class Pair {
    public int pairId;
    public Card firstCard;
    public Card secondCard;


    public Pair(int pairId, Card firstCard, Card secondCard){
        this.pairId = pairId;
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }
}
