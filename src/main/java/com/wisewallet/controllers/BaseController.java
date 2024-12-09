package com.wisewallet.controllers;

import com.wisewallet.vision.MainApplication;

public abstract class BaseController {
    protected MainApplication mainApp;

    public void setMainApp(MainApplication mainApp){
        this.mainApp = mainApp;
    }
}
