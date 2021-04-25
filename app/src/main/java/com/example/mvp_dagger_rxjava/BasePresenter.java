package com.example.mvp_dagger_rxjava;

import android.util.Log;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter {
    interface UIController{
        void onLoading();
        void onSuccess();
        void onError();
    }

    interface ResponseObserver<T>{
        void onSuccess(T result);
        void onError(Throwable throwable);
    }

    CompositeDisposable compositeSubscription;
    UIController uiController;

    public BasePresenter(UIController uiController) {
        this.compositeSubscription = new CompositeDisposable();
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
}
