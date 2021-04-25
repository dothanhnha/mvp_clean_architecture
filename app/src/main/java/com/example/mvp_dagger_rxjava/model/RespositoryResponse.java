package com.example.mvp_dagger_rxjava.model;

import java.util.List;

public class RespositoryResponse {
    private boolean incomplete_results;
    private int total_count;
    private List<Repository> items;

    public RespositoryResponse(boolean incomplete_results, int total_count, List<Repository> item) {
        this.incomplete_results = incomplete_results;
        this.total_count = total_count;
        this.items = item;
    }
}
