package com.example.ayalabartal.concentrationgame.mainMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ayalabartal.concentrationgame.R;
import com.example.ayalabartal.concentrationgame.di.ExampleApp;
import com.example.ayalabartal.concentrationgame.di.MainMenuControllerComponent;

import javax.inject.Inject;

public class MainMenuActivity extends AppCompatActivity {

    @Inject
    MainMenuController mainMenuController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        MainMenuControllerComponent component = ((ExampleApp)getApplication()).getMainMenuControllerComponent();
        mainMenuController = component.getMainMenuController();

        Button newGameBtn = findViewById(R.id.newGameBtn);
        newGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenuController.startNewGame(getApplication());
            }
        });
    }
}