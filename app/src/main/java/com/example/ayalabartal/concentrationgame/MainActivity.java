package com.example.ayalabartal.concentrationgame;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickToChangeColor(R.id.square1);
        clickToChangeColor(R.id.square2);
        clickToChangeColor(R.id.square3);
        clickToChangeColor(R.id.square4);
    }

    private void clickToChangeColor(int id) {
        final LinearLayout layout = findViewById(id);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentColor = getLayoutColor(layout);
                layout.setBackgroundColor(currentColor == getResources().getColor(R.color.blue1) ? getResources().getColor(R.color.purple) : getResources().getColor(R.color.blue1));
            }
        });

    }

    private int getLayoutColor(LinearLayout layout) {
        int color = Color.TRANSPARENT;
        Drawable background = layout.getBackground();
        return background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : color;
    }
}
