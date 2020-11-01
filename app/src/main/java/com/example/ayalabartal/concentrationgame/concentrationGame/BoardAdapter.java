package com.example.ayalabartal.concentrationgame.concentrationGame;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.entities.Card;

import java.util.List;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.CardViewHolder> {

    private LayoutInflater layoutInflater;
    private List<Card> cardList;
    private ItemClickListener mClickListener;

    public BoardAdapter(Context context, List<Card> cardList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.cardList = cardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.card, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        cardList.get(i).setCardText(cardViewHolder.cardText);
        cardViewHolder.cardText.setText(cardList.get(i).getContent());
    }

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView cardText;

        public CardViewHolder(View v) {
            super(v);
            cardText = v.findViewById(R.id.cardText);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {

        void onItemClick(View view, int position);
    }
}
