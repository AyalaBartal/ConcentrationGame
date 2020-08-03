package com.example.ayalabartal.concentrationgame.ui.services;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.entities.Card;

import java.util.List;

public class DrawFactory {

    private Activity activity;

    public DrawFactory(Activity activity){
        this.activity = activity;
    }

    void connectCardAndViews(Card card, LinearLayout.LayoutParams params){
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = layoutInflater.inflate(R.layout.card, null);
        cardView.setLayoutParams(params);
        card.setCardView(cardView);
        card.setCardText((TextView) card.getCardView().findViewById(R.id.cardText));
        card.getCardText().setText(card.getContent());
    }

    LinearLayout createHorizontalLineOfCards(List<View> cardList){
        LinearLayout lineLayout =new LinearLayout(activity);
        for (View cardView: cardList) {
            lineLayout.addView(cardView);
        }
        return lineLayout;
    }

    void drawBoard(List<LinearLayout> hsvList) {
        ScrollView contentScrollView =  activity.findViewById(R.id.content);
        LinearLayout contentLayout = new LinearLayout(activity);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        for (LinearLayout hsv: hsvList) {
            contentLayout.addView(hsv);
        }
        contentScrollView.addView(contentLayout);
    }
}
