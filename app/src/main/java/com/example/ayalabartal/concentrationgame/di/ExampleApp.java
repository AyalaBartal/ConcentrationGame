package com.example.ayalabartal.concentrationgame.di;

import android.app.Application;

public class ExampleApp extends Application {

    private ConcentrationGameControllerComponent concentrationGameControllerComponent;
    private ServerComponent serverComponent;
    private MainMenuControllerComponent mainMenuControllerComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        concentrationGameControllerComponent = DaggerConcentrationGameControllerComponent.create();
        serverComponent = DaggerServerComponent.create();
        mainMenuControllerComponent = DaggerMainMenuControllerComponent.create();
    }

    public ConcentrationGameControllerComponent getConcentrationGameControllerComponent() {
        return concentrationGameControllerComponent;
    }

    public ServerComponent getServerComponent(){
        return serverComponent;
    }

    public MainMenuControllerComponent getMainMenuControllerComponent() {
        return mainMenuControllerComponent;
    }
}
