package com.example.mvp_dagger_rxjava.base;

import com.example.mvp_dagger_rxjava.exception.ApiNetworkTimeoutException;
import com.example.mvp_dagger_rxjava.exception.ApiNetworkUnavailableException;
import com.example.mvp_dagger_rxjava.exception.ApiServerException;
import com.example.mvp_dagger_rxjava.exception.ApiUnknownException;
import com.example.mvp_dagger_rxjava.exception.ApiUnknownHostException;
import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.HttpException;

public class BaseRepos {
    protected  <T> Observable<T> genObservableWithErrorAPI(Observable<T> observable){
        return observable
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(Throwable throwable) throws Exception {
                        if (throwable instanceof HttpException) {
                            return Observable.error(new ApiServerException(throwable));
                        } else if (throwable instanceof UnknownHostException) {
                            return Observable.error(new ApiUnknownHostException(throwable));
                        } else if ((throwable instanceof TimeoutException) || (throwable instanceof SocketTimeoutException)) {
                            return Observable.error(new ApiNetworkTimeoutException(throwable));
                        } else if (throwable instanceof ConnectException || throwable instanceof IOException) {
                            return Observable.error(new ApiNetworkUnavailableException(throwable));
                        }
                        return Observable.error(new ApiUnknownException(throwable));
                    }
                });

    }
}
