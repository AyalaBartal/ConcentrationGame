package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.concentrationGame.ConcentrationGameController;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ConcentrationGameControllerModule.class)
public interface ConcentrationGameControllerComponent {

    ConcentrationGameController getConcentrationGameController();
}
