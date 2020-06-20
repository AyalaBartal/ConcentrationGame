package com.example.ayalabartal.concentrationgame.entities;

import java.util.List;

public class TurnResult {
    public boolean correct;
    public List<Pair> pairList;

    public TurnResult(List<Pair> pairList){
        this.pairList = pairList;
    }

    public TurnResult(boolean correct){
        this.correct = correct;
    }
}
