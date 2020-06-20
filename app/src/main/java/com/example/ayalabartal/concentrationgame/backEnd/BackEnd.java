package com.example.ayalabartal.concentrationgame.backEnd;

import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.Pair;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.ArrayList;
import java.util.List;

public class BackEnd {

    List<Pair> pairList;

    public TurnResult processRequest(TurnRequest request){
        return request.firstTurn ?  createGame() : processTurn(request);
    }

    private TurnResult createGame() {
        pairList = new ArrayList<Pair>();
        pairList.add(new Pair(1, new Card(1, 1, "A"), new Card(2, 1, "A")));
        pairList.add(new Pair(2, new Card(1, 2, "B"), new Card(2, 2, "B")));
        return new TurnResult(pairList);
    }

    private TurnResult processTurn(TurnRequest request) {
        return new TurnResult(request.firstCard.pairId == request.secondCard.pairId);
    }

}
