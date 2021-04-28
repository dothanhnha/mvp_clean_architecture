package com.example.mvp_dagger_rxjava;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<C extends BasePresenter.HolderData> extends AppCompatActivity implements BasePresenter.BaseUIController {
    private LoadingDialog loadingDialog;
    private boolean isShowLoading = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onRestore(savedInstanceState);
        getPresenter().register(this);
        onIdle();
        if(getPresenter().isRestored())
            onRestore((C)getPresenter().getHolderData());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getPresenter().onSave(outState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadingDialog = new LoadingDialog(this);
    }

    protected abstract void onRestore(C dataHolder);

    @Override
    public void onLoading() {
        showLoadingDialog();
    }

    @Override
    public void onSuccess() {
        hiddenLoadingDialog();
    }

    @Override
    public void onError() {
        hiddenLoadingDialog();
    }

    @Override
    public void onIdle() {
        hiddenLoadingDialog();
    }

    private void showLoadingDialog(){
        if(!isShowLoading){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
            loadingDialog.show();
            isShowLoading = true;
        }
    }

    private void hiddenLoadingDialog(){
        if(isShowLoading){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
            loadingDialog.dismiss();
            isShowLoading = false;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
    }
}
