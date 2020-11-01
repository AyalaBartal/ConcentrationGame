package com.example.ayalabartal.concentrationgame.concentrationGame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.di.ConcentrationGameControllerComponent;
import com.example.ayalabartal.concentrationgame.di.ExampleApp;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;

import java.util.List;

import javax.inject.Inject;

public class ConcentrationGameActivity extends AppCompatActivity implements BoardAdapter.ItemClickListener{

    @Inject
    ConcentrationGameController controller;
    private List<Card> cardList;
    private TurnRequest request;
    private int correctAnswerNumber;
    private TextView yourScoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentration_game);

        ConcentrationGameControllerComponent component =  ((ExampleApp)getApplication()).getConcentrationGameControllerComponent();
        controller = component.getConcentrationGameController();

        request = new TurnRequest();

        getCardList();

        crateRecyclerView();

        setMaxGameScoreText();

        setYourScoreText();
    }

    private void getCardList() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Card List");
        cardList = (List<Card>) bundle.getSerializable("Card List");
    }

    private void crateRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.content);
        int numberOfColumns = 6;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        BoardAdapter adapter = new BoardAdapter(this, cardList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int i) {
        Card card = cardList.get(i);
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

    private void checkResult() {
        TurnResult result = controller.processRequest(request);
        if (result.correct){
            correctAnswerNumber++;
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

    private void setMaxGameScoreText() {
        TextView maxGameScore = findViewById(R.id.maxScoreText);
        maxGameScore.setText(String.valueOf(cardList.size()/2));
    }

    private void setYourScoreText() {
        yourScoreText  = findViewById(R.id.yourScoreText);
        yourScoreText.setText(String.valueOf(correctAnswerNumber));
    }
}