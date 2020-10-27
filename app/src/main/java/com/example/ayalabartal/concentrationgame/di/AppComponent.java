package com.example.ayalabartal.concentrationgame.di;

import com.example.ayalabartal.concentrationgame.mainActivity.Controller;
import com.example.ayalabartal.concentrationgame.mainActivity.ServerAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ControllerModule.class, ServerModule.class})
public interface AppComponent {

    Controller getController();
    ServerAdapter getServerAdapter();

}
