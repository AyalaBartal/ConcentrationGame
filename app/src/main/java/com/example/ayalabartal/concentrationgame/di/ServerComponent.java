package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.concentrationGame.ServerAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ServerComponent {

    ServerAdapter getServerAdapter();
}
