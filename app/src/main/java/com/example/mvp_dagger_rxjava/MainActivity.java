package com.example.mvp_dagger_rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;
import com.example.mvp_dagger_rxjava.repos.SearchRepositoriesRepos;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Inject
    SearchRepositoriesRepos repos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication)getApplicationContext())
                .getAppComponent().mainComponent().create()
                .inject(this);

        repos.getRepositories(SearchRepositoriesApi.SortType.STAR, "android",5,1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RespositoryResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull RespositoryResponse respositoryResponse) {
                        Log.d("success",respositoryResponse.toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("error",e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}