package com.example.ayalabartal.concentrationgame.frontEnd.services;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.ayalabartal.concentrationgame.entities.Card;

import java.util.ArrayList;
import java.util.List;


public class DrawBoardService {

    private List<Card> cardList;
    private DrawFactory drawFactory;
    private LinearLayout.LayoutParams cardParams;
    private HorizontalScrollView.LayoutParams svParams;

    public DrawBoardService(List<Card> cardList, DrawFactory drawFactory, LinearLayout.LayoutParams cardParams, HorizontalScrollView.LayoutParams svParams){
        this.cardList = cardList;
        this.drawFactory = drawFactory;
        this.cardParams = cardParams;
        this.svParams = svParams;
    }

    public void draw(int numberOfRows, int numberOfColumns, int contentViewId, int textViewId) {
        List<HorizontalScrollView> hsvList = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            List<View> cardViewList = new ArrayList<>();
            for (int column = 0; column < numberOfColumns; column++) {
                Card card = cardList.get((row * numberOfColumns) + column);
                drawFactory.connectCardAndViews(card, cardParams, textViewId);
                cardViewList.add(card.getCardView());
            }
            hsvList.add(drawFactory.createHorizontalScrollViewContent(svParams, cardViewList));
        }
        drawFactory.drawBoard(hsvList, contentViewId);
    }

}
