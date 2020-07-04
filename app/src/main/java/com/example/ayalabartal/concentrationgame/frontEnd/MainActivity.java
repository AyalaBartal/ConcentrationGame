package com.example.ayalabartal.concentrationgame.frontEnd;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.backEnd.BackEnd;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;
import com.example.ayalabartal.concentrationgame.frontEnd.services.DrawBoardService;
import com.example.ayalabartal.concentrationgame.frontEnd.services.DrawFactory;

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
        drawBoard(cardList);
        setMaxGameScore(cardList.size());
        for (Card card: cardList) {
            createOnClickListener(card);
        }
        request = new TurnRequest();
    }

    private void setMaxGameScore(int size) {
        TextView maxGameScore = findViewById(R.id.maxScoreText);
        maxGameScore.setText(String.valueOf(size/2));
    }

    private void drawBoard(List<Card> cardList) {
        DrawFactory df = new DrawFactory(this);
        LinearLayout.LayoutParams cardParams = new LinearLayout.LayoutParams(0, 500, 1);
        cardParams.setMargins(50, 50, 50, 50);
        DrawBoardService dbs = new DrawBoardService(cardList, df, cardParams);
        dbs.draw(4, 4);
    }

    private List<Card> createNewGame() {
        backEnd = new BackEnd();
        TurnResult result = backEnd.processRequest(new TurnRequest(true));
       return result.cardList;
    }

    private void createOnClickListener(final Card card) {
        View cardView = card.getCardView();
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (request.secondCard == null && card.getCardText().getVisibility() == View.INVISIBLE) {
                   card.getCardText().setVisibility(View.VISIBLE);
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
                request.firstCard.getCardText().setVisibility(View.INVISIBLE);
                request.secondCard.getCardText().setVisibility(View.INVISIBLE);
                request.firstCard = null;
                request.secondCard = null;
            }
        }, 1000);
    }
}
