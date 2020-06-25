package com.example.ayalabartal.concentrationgame.entities;

import java.util.List;

public class TurnResult {
    public boolean correct;
    public List<Card> cardList;

    public TurnResult(List<Card> cardList){
        this.cardList = cardList;
    }

    public TurnResult(boolean correct){
        this.correct = correct;
    }
}
