package com.example.mvp_dagger_rxjava.di;

import com.example.mvp_dagger_rxjava.SearchRepositoriesApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

@Module
class RetrofitNetworkModule {
    private static final String BASE_URL = "https://api.github.com";

    private static final Long CONNECT_TIMEOUT_SECOND =20L;
    private static final Long WRITE_TIMEOUT_SECOND =20L;
    private static final Long READ_TIMEOUT_SECOND =20L;
    private static final Gson convertDateTime = new GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        .create();

    @Provides
    @Singleton
    public OkHttpClient getClient(){
        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIMEOUT_SECOND * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT_SECOND * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT_SECOND * 1000, TimeUnit.MILLISECONDS)
                .build();
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(convertDateTime))
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public SearchRepositoriesApi currentWeatherAPI(Retrofit retrofit){
        return retrofit.create(SearchRepositoriesApi.class);
    }

}
