package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainMenu.MainMenuController;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface MainMenuControllerComponent {

    MainMenuController getMainMenuController();
}
