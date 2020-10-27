package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainActivity.Controller;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface ControllerComponent {

    Controller getController();
}
