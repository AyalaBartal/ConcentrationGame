package com.example.ayalabartal.concentrationgame.di;

import android.content.Context;

import com.example.ayalabartal.concentrationgame.concentrationGame.ConcentrationGameController;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ConcentrationGameControllerModule {

    @Provides
    @Singleton
    static ConcentrationGameController provideController() {
        return new ConcentrationGameController();
    }
}
