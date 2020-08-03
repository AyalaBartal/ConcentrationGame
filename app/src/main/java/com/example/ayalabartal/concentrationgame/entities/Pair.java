package com.example.ayalabartal.concentrationgame.entities;

public class Pair {
    private int pairId;
    private Card firstCard;
    private Card secondCard;

    public Pair(int pairId, Card firstCard, Card secondCard){
        this.pairId = pairId;
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

    public int getPairId() {
        return pairId;
    }

    public Card getFirstCard() {
        return firstCard;
    }

    public Card getSecondCard() {
        return secondCard;
    }

}
