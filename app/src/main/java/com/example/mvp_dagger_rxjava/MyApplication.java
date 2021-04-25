package com.example.mvp_dagger_rxjava;

import android.app.Application;

import com.example.mvp_dagger_rxjava.di.AppComponent;
import com.example.mvp_dagger_rxjava.di.DaggerAppComponent;

public class MyApplication extends Application {
    private AppComponent appComponent = DaggerAppComponent.create();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
