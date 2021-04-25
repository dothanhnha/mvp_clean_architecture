package com.example.mvp_dagger_rxjava;

import androidx.annotation.NonNull;
import com.example.mvp_dagger_rxjava.model.RespositoryResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchRepositoriesApi {
    final String GET_REPOSITORIES = "search/repositories";

    public enum SortType {
        STAR("stars"),
        FORKS("forks"),
        HELP_WANTED_ISSUES("help-wanted-issues"),
        UPDATED("updated");
        private String value;

        SortType(String value) {
            this.value = value;
        }

        @NonNull
        @Override
        public String toString() {
            return this.value;
        }
    }

    @GET(GET_REPOSITORIES)
    public Observable<RespositoryResponse> getRepositories(@Query("sort") SortType sortType, @Query("q") String query,
                                                           @Query("per_page") int perPage, @Query("page") int page);
}