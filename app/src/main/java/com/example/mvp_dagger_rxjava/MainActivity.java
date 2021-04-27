package com.example.mvp_dagger_rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;
import com.example.mvp_dagger_rxjava.repos.SearchRepositoriesRepos;
import com.github.ybq.android.spinkit.SpinKitView;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity implements MainPresenter.MainUIController {

    @Inject
    SearchRepositoriesRepos repos;

    @Inject
    MainPresenter presenter;

    SpinKitView spinKitView;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyApplication)getApplicationContext())
                .getAppComponent().mainComponent().create()
                .inject(this);


        spinKitView = findViewById(R.id.spin_kit);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            presenter.requestAPI(repos.getRepositories(SearchRepositoriesApi.SortType.STAR, "android", 5, 1),
                    new BasePresenter.ResponseObserver<RespositoryResponse>() {
                        @Override
                        public void onSuccess(RespositoryResponse result) {
                            presenter.getHolderData().response = result;
                        }

                        @Override
                        public void onError(Throwable throwable) {
                        }
                    });
        });

    }

    @Override
    public void onLoading() {
        spinKitView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onSuccess() {
        spinKitView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError() {
        spinKitView.setVisibility(View.INVISIBLE);
    }
}