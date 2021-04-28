package com.example.mvp_dagger_rxjava;

import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

public abstract class BasePresenter<T extends BasePresenter.BaseUIController, C extends BasePresenter.HolderData> {
    private static final String KEY_HOLDER_DATA = "KEY_HOLDER_DATA";
    interface HolderData extends Serializable {
    }

    interface BaseUIController {
        void onLoading();
        void onSuccess();
        void onError();
        void onIdle();
        BasePresenter getPresenter();
    }

    interface ResponseObserver<T>{
        void onSuccess(T result);
        void onError(Throwable throwable);
    }

    private CompositeDisposable compositeSubscription;
    protected T uiController;

    private C holderData;

    private boolean isRestored = false;

    public boolean isRestored() {
        return isRestored;
    }

    public C getHolderData() {
        return holderData;
    }

    public BasePresenter(C holderData) {
        this.holderData = holderData;
        this.compositeSubscription = new CompositeDisposable();
    }

    public void register(T uiController){
        this.uiController = uiController;
    }

    public <T> void requestAPI(Observable<T> observable, ResponseObserver<T> observer) {

        this.uiController.onLoading();
        this.compositeSubscription.add(observable
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(error -> {
                    BasePresenter.this.uiController.onError();
                    observer.onError(error);
                })
                .doOnNext(response -> {
                    BasePresenter.this.uiController.onSuccess();
                    observer.onSuccess(response);
                })
                .subscribe());
    }

    public void onDestroy(){
        this.compositeSubscription.clear();
        this.compositeSubscription.dispose();
    }

    public void onSave(Bundle outState){
        outState.putSerializable(KEY_HOLDER_DATA, holderData);
    }

    public boolean onRestore(Bundle savedInstanceState){
        if(savedInstanceState == null){
            isRestored = false;
        }
        else{
            C data = (C) savedInstanceState.getSerializable(KEY_HOLDER_DATA);
            if(data != null){
                this.holderData = data;
                isRestored = true;
            }
            else
                isRestored = false;
        }
        return isRestored;
    }
}
