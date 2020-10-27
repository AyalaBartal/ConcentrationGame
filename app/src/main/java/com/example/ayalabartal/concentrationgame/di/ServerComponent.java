package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainActivity.ServerAdapter;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component
public interface ServerComponent {

    ServerAdapter getServerAdapter();
}
