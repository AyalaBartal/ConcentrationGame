package com.example.ayalabartal.concentrationgame.entities;

public class TurnRequest {
    public boolean firstTurn;
    public Card firstCard;
    public Card secondCard;

    public TurnRequest(){
        firstCard = null;
        secondCard = null;
    }

    public TurnRequest(Card firstCard, Card secondCard){
        this.firstCard = firstCard;
        this.secondCard = secondCard;
    }

    public TurnRequest(boolean firstTurn){
        this.firstTurn = firstTurn;
    }
}
