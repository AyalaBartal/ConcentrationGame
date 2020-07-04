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

    public DrawBoardService(List<Card> cardList, DrawFactory drawFactory, LinearLayout.LayoutParams cardParams){
        this.cardList = cardList;
        this.drawFactory = drawFactory;
        this.cardParams = cardParams;
    }

    public void draw(int numberOfRows, int numberOfColumns) {
        List<LinearLayout> linesList = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            List<View> cardViewList = new ArrayList<>();
            for (int column = 0; column < numberOfColumns; column++) {
                Card card = cardList.get((row * numberOfColumns) + column);
                drawFactory.connectCardAndViews(card, cardParams);
                cardViewList.add(card.getCardView());
            }
            linesList.add(drawFactory.createHorizontalLineOfCards(cardViewList));
        }
        drawFactory.drawBoard(linesList);
    }

}
