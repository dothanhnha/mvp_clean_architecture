package com.example.mvp_dagger_rxjava.repos;

import com.example.mvp_dagger_rxjava.base.BaseRepos;
import com.example.mvp_dagger_rxjava.api.SearchRepositoriesApi;
import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class SearchRepositoriesRepos extends BaseRepos {
    private SearchRepositoriesApi searchRepositoriesApi;

    @Inject
    public SearchRepositoriesRepos(SearchRepositoriesApi searchRepositoriesApi) {
        this.searchRepositoriesApi = searchRepositoriesApi;
    }

    public Observable<RespositoryResponse> getRepositories(SearchRepositoriesApi.SortType sortType, String query,
                                                           int perPage, int page) {
        return this.genObservableWithErrorAPI(this.searchRepositoriesApi
                .getRepositories(sortType, query, perPage, page));
    }
}