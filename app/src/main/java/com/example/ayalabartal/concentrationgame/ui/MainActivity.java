package com.example.ayalabartal.concentrationgame.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.api.GameFactory;
import com.example.ayalabartal.concentrationgame.api.ServerGameApi;
import com.example.ayalabartal.concentrationgame.backEnd.BackEnd;
import com.example.ayalabartal.concentrationgame.entities.Card;
import com.example.ayalabartal.concentrationgame.entities.Pair;
import com.example.ayalabartal.concentrationgame.entities.TurnRequest;
import com.example.ayalabartal.concentrationgame.entities.TurnResult;
import com.example.ayalabartal.concentrationgame.ui.services.DrawBoardService;
import com.example.ayalabartal.concentrationgame.ui.services.DrawFactory;

import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {

    TurnRequest request;
    BackEnd backEnd;
    int correctAnswerNumber;
//    Intent intent;
    List<Card> cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String m_ip = /*((IpAddress)this.getApplication()).getIpAddress();*/"127.0.0.1";
//        if (intent == null){
/*            Controller controller = new Controller(m_ip);
            cardList = controller.createNewGameRequest();*/
//        }
//        else{
//
//        }

//        List<Card> cardList = createNewGame();
        
        callServer(m_ip);
        drawBoard(cardList);
        setMaxGameScore(cardList.size());
        for (Card card: cardList) {
            createOnClickListener(card);
        }
        request = new TurnRequest();
    }

    private void callServer(String m_ip) {
        ServerGameApi serverApi = GameFactory.createGameApi(m_ip);
        Call<Collection<Pair>> callBack = serverApi.getAll();
        callBack.enqueue(getPairListCallBack());
    }

    private Callback<Collection<Pair>> getPairListCallBack() {
        Callback<Collection<Pair>> result = new Callback<Collection<Pair>>() {
            @Override
            public void onResponse(Call<Collection<Pair>> call, Response<Collection<Pair>> response) {
                List<Pair> pairList = (List)response.body();
            }

            @Override
            public void onFailure(Call<Collection<Pair>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        };
        return result;
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
