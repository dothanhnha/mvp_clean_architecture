package com.example.mvp_dagger_rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp_dagger_rxjava.model.RespositoryResponse;
import com.example.mvp_dagger_rxjava.repos.SearchRepositoriesRepos;
import com.github.ybq.android.spinkit.SpinKitView;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends BaseActivity<MainPresenter.MainDataHolder> implements MainPresenter.MainUIController {

    @Inject
    SearchRepositoriesRepos repos;

    @Inject
    MainPresenter presenter;

    SpinKitView spinKitView;

    Button button;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication)getApplicationContext())
                .getAppComponent().mainComponent().create()
                .inject(this);
        setContentView(R.layout.activity_main);
        spinKitView = findViewById(R.id.spin_kit);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            presenter.requestAPI(repos.getRepositories(SearchRepositoriesApi.SortType.STAR, "android", 5, 1),
                    new BasePresenter.ResponseObserver<RespositoryResponse>() {
                        @Override
                        public void onSuccess(RespositoryResponse result) {
                            presenter.setResponse(result);
                        }

                        @Override
                        public void onError(Throwable throwable) {

                        }
                    });
        });
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestore(MainPresenter.MainDataHolder dataHolder) {
        onResponse(dataHolder.response);
    }

    @Override
    public BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void onResponse(RespositoryResponse response) {
        if(response != null)
            textView.setText(String.valueOf(response.getTotal_count()));
    }
}