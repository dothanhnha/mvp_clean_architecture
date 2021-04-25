package com.example.mvp_dagger_rxjava.di;

import android.content.Context;

import com.example.mvp_dagger_rxjava.main.di.MainComponent;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.Module;


@Singleton
@Component(
        modules = {
                AppComponent.SubcomponentsModule.class,
                RetrofitNetworkModule.class}
)
public interface AppComponent {
/*    @Component.Factory
    interface Factory {
        AppComponent create(@BindsInstance Context applicationContext);
    }*/

    MainComponent.Factory mainComponent();

    @Module(subcomponents = {MainComponent.class})
    class SubcomponentsModule {
    }
}