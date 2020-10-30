package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.concentrationGame.ConcentrationGameController;
import com.example.ayalabartal.concentrationgame.concentrationGame.ServerAdapter;
import com.example.ayalabartal.concentrationgame.mainMenu.MainMenuController;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ConcentrationGameControllerModule.class, ServerModule.class, MainMenuControllerModule.class})
public interface AppComponent {

    ConcentrationGameController getController();
    ServerAdapter getServerAdapter();
    MainMenuController getMainMenuController();

}
