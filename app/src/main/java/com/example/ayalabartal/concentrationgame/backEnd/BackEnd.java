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
        pairList.add(new Pair(1, new Card(1, "A"), new Card( 1, "A")));
        pairList.add(new Pair(2, new Card( 2, "B"), new Card( 2, "B")));
        pairList.add(new Pair(3, new Card( 3, "C"), new Card( 3, "C")));
        pairList.add(new Pair(4, new Card( 4, "D"), new Card( 4, "D")));
        pairList.add(new Pair(5, new Card( 5, "E"), new Card( 5, "E")));
        pairList.add(new Pair(6, new Card( 6, "F"), new Card( 6, "F")));
        pairList.add(new Pair(7, new Card( 7, "G"), new Card( 7, "G")));
        pairList.add(new Pair(8, new Card( 8, "H"), new Card( 8, "H")));
        pairList.add(new Pair(9, new Card( 9, "I"), new Card( 9, "I")));
        pairList.add(new Pair(10, new Card( 10, "J"), new Card( 10, "J")));
        pairList.add(new Pair(11, new Card( 11, "K"), new Card( 11, "K")));
        pairList.add(new Pair(12, new Card( 12, "L"), new Card( 12, "L")));
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
