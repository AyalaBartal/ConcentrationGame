package com.example.ayalabartal.concentrationgame.frontEnd.services;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
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

    void connectCardAndViews(Card card, LinearLayout.LayoutParams params, int textViewId){
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View cardView = layoutInflater.inflate(R.layout.card, null);
        cardView.setLayoutParams(params);
        card.setCardView(cardView);
        card.setCardText((TextView) card.getCardView().findViewById(textViewId));
        card.getCardText().setText(card.getContent());
    }

    HorizontalScrollView createHorizontalScrollViewContent(HorizontalScrollView.LayoutParams params, List<View> cardList){
        LinearLayout lineLayout =new LinearLayout(activity);
        for (View cardView: cardList) {
            lineLayout.addView(cardView);
        }
        HorizontalScrollView hsv = new HorizontalScrollView(activity);
        hsv.setLayoutParams(params);
        hsv.addView(lineLayout);
        return hsv;
    }


    void drawBoard(List<HorizontalScrollView> hsvList, int contentViewId) {
        ScrollView contentScrollView =  activity.findViewById(contentViewId);
        LinearLayout contentLayout = new LinearLayout(activity);
        contentLayout.setOrientation(LinearLayout.VERTICAL);
        for (HorizontalScrollView hsv: hsvList) {
            contentLayout.addView(hsv);
        }
        contentScrollView.addView(contentLayout);
    }
}
