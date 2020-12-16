package com.example.ayalabartal.concentrationgame.entities;

import javax.inject.Inject;

public class TurnRequest {
    public Card firstCard;
    public Card secondCard;

    @Inject
    public TurnRequest(){
        firstCard = null;
        secondCard = null;
    }

}
