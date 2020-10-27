package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainActivity.ServerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ServerModule {

    @Provides
    @Singleton
    static ServerAdapter provideServerAdapter() {
        return new ServerAdapter();
    }
}
