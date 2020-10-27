package com.example.ayalabartal.concentrationgame.backEnd;

import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.Pair;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackEnd {

    List<Pair> pairList;

    public List<Card> createGame() {
        List<Pair> pairList = createPairList();
        return createShuffledCardList(pairList);
    }

    private List<Pair> createPairList() {
        pairList = new ArrayList<Pair>();
        pairList.add(new Pair(1, new Card(1, 1, "A"), new Card(2, 1, "A")));
        pairList.add(new Pair(2, new Card(1, 2, "B"), new Card(2, 2, "B")));
        pairList.add(new Pair(3, new Card(1, 3, "C"), new Card(2, 3, "C")));
        pairList.add(new Pair(4, new Card(1, 4, "D"), new Card(2, 4, "D")));
        pairList.add(new Pair(5, new Card(1, 5, "E"), new Card(2, 5, "E")));
        pairList.add(new Pair(6, new Card(1, 6, "F"), new Card(2, 6, "F")));
        pairList.add(new Pair(7, new Card(1, 7, "G"), new Card(2, 7, "G")));
        pairList.add(new Pair(8, new Card(1, 8, "H"), new Card(2, 8, "H")));
        return pairList;
    }

    private List<Card> createShuffledCardList(List<Pair> pairList) {
        List<Card> cardList = new ArrayList<Card>();
        for (Pair pair: pairList) {
            cardList.add(pair.getFirstCard());
            cardList.add(pair.getSecondCard());
        }
        Collections.shuffle(cardList);
        return cardList;
    }

    public TurnResult processTurn(TurnRequest request) {
        return new TurnResult(request.firstCard.getPairId() == request.secondCard.getPairId());
    }

}
