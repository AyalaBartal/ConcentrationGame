package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainActivity.Controller;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ControllerModule {

    @Provides
    @Singleton
    static Controller provideController() {
        return new Controller();
    }
}
