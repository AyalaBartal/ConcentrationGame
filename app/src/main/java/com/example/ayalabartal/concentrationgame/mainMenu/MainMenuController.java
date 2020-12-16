package com.example.ayalabartal.concentrationgame.mainMenu;

import android.content.Context;

import com.example.ayalabartal.concentrationgame.di.ConcentrationGameControllerComponent;
import com.example.ayalabartal.concentrationgame.di.ExampleApp;

import javax.inject.Inject;

public class MainMenuController {

    @Inject
    public MainMenuController() {

    }

    public void startNewGame(Context context) {
        ConcentrationGameControllerComponent component = ((ExampleApp)context.getApplicationContext()).getConcentrationGameControllerComponent();
        component.getConcentrationGameController().createNewGame(context);
    }
}
