package com.example.mvp_dagger_rxjava.main;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp_dagger_rxjava.MyApplication;
import com.example.mvp_dagger_rxjava.R;
import com.example.mvp_dagger_rxjava.api.SearchRepositoriesApi;
import com.example.mvp_dagger_rxjava.base.BaseActivity;
import com.example.mvp_dagger_rxjava.base.BasePresenter;
import com.example.mvp_dagger_rxjava.model.Repository;
import com.example.mvp_dagger_rxjava.model.RespositoryResponse;
import com.example.mvp_dagger_rxjava.repos.SearchRepositoriesRepos;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<MainPresenter.MainDataHolder> implements MainPresenter.MainUIController {

    @Inject
    SearchRepositoriesRepos repos;
    @Inject
    MainPresenter presenter;

    @Inject
    ReposAdapter reposAdapter;

    ImageButton button;
    TextView textView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication)getApplicationContext())
                .getAppComponent().mainComponent().create()
                .inject(this);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.queryEditText);
        textView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                sendRequest();
                return true;
            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            sendRequest();
        });

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(reposAdapter);

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
        if(response != null){
            reposAdapter.dataset = (ArrayList<Repository>) response.getItems();
            reposAdapter.notifyDataSetChanged();
        }
    }

    private void sendRequest(){
        presenter.requestAPI(repos.getRepositories(SearchRepositoriesApi.SortType.STAR, textView.getText().toString(), 20, 0),
                new BasePresenter.ResponseObserver<RespositoryResponse>() {
                    @Override
                    public void onSuccess(RespositoryResponse result) {
                        presenter.setResponse(result);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }
                });
    }
}