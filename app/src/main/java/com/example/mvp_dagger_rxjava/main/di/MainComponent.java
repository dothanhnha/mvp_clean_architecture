package com.example.mvp_dagger_rxjava.main.di;

import com.example.mvp_dagger_rxjava.MainActivity;

import dagger.Subcomponent;

@Subcomponent
public
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        public MainComponent create();
    }

    public void inject(MainActivity activity);
}
