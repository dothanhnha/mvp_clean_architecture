package com.example.mvp_dagger_rxjava;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainPresenter.MainUIController, MainPresenter.MainDataHolder> {

    @Inject
    public MainPresenter(MainDataHolder holderData) {
        super(holderData);
    }

    interface MainUIController extends BasePresenter.BaseUIController{
        void onResponse(RespositoryResponse  response);
    }

    static class MainDataHolder implements BasePresenter.HolderData{
        RespositoryResponse  response;

        @Inject
        public MainDataHolder() {
        }
    }

    public void setResponse(RespositoryResponse  response){
        getHolderData().response = response;
        uiController.onResponse(response);
    }
}
