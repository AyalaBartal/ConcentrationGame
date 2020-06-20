package com.example.ayalabartal.concentrationgame.frontEnd;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.backEnd.BackEnd;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.Pair;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TurnRequest request;
    BackEnd backEnd;
    int correctAnswerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Card> cardList = createNewGame();
        createCardView(cardList.get(0), R.id.card1);
        createCardView(cardList.get(1), R.id.card2);
        createCardView(cardList.get(2), R.id.card3);
        createCardView(cardList.get(3), R.id.card4);
    }

    private List<Card> createNewGame() {
        backEnd = new BackEnd();
        TurnResult result = backEnd.processRequest(new TurnRequest(true));
        return createCardList(result.pairList);
    }

    @NonNull
    private List<Card> createCardList(List<Pair> pairList) {
        List<Card> cardList = new ArrayList<Card>();
        for (Pair pair: pairList) {
            cardList.add(pair.firstCard);
            cardList.add(pair.secondCard);
        }
        return cardList;
    }

    private void createCardView(Card card, int viewId) {
        connectCardToView(card, viewId);
        createOnClickListener(card, viewId);
        request = new TurnRequest();
    }

    private void connectCardToView(Card card, int viewId) {
        View cardView = findViewById(viewId);
        TextView cardText = cardView.findViewById(R.id.cardText);
        cardText.setText(card.content);
        card.cardText = cardText;
    }

    private void createOnClickListener(final Card card, int viewId) {
        View cardView = findViewById(viewId);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (card.cardText.getVisibility() == View.INVISIBLE) {
                   card.cardText.setVisibility(View.VISIBLE);
                    if (request.firstCard == null) {
                        request.firstCard = card;
                    }else{
                        request.secondCard = card;
                        checkResult();
                    }
                }
            }
        });
    }

    private void checkResult() {
        TurnResult result = backEnd.processRequest(request);
        if (result.correct){
            correctAnswerNumber++;
            TextView yourScoreText = findViewById(R.id.yourScoreText);
            yourScoreText.setText(String.valueOf(correctAnswerNumber));
            request.firstCard = null;
            request.secondCard = null;
        }else{
            flipOverCards();
        }
    }

    private void flipOverCards() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                request.firstCard.cardText.setVisibility(View.INVISIBLE);
                request.secondCard.cardText.setVisibility(View.INVISIBLE);
                request.firstCard = null;
                request.secondCard = null;
            }
        }, 1000);
    }
}
