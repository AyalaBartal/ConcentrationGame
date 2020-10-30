package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainMenu.MainMenuController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class MainMenuControllerModule {

    @Singleton
    @Provides
    static MainMenuController provideMainMenuController(){
        return new MainMenuController();
    }
}
