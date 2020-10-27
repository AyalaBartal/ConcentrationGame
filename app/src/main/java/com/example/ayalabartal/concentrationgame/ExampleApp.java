package com.example.ayalabartal.concentrationgame;

import android.app.Application;

import com.example.ayalabartal.concentrationgame.di.ControllerComponent;
import com.example.ayalabartal.concentrationgame.di.DaggerControllerComponent;
import com.example.ayalabartal.concentrationgame.di.DaggerServerComponent;
import com.example.ayalabartal.concentrationgame.di.ServerComponent;

public class ExampleApp extends Application {

    private ControllerComponent controllerComponent;
    private ServerComponent serverComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        controllerComponent = DaggerControllerComponent.create();
        serverComponent = DaggerServerComponent.create();
    }

    public ControllerComponent getAppComponent() {
        return controllerComponent;
    }

    public ServerComponent getServerComponent(){
        return serverComponent;
    }
}
