package com.example.mvp_dagger_rxjava;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainPresenter extends BasePresenter<MainPresenter.MainUIController, MainPresenter.MainDataHolder> {
    interface MainUIController extends BasePresenter.BaseUIController{

    }

    class MainDataHolder implements BasePresenter.HolderData{
        RespositoryResponse  response;
    }

    @Inject
    public MainPresenter() {

    }
}
