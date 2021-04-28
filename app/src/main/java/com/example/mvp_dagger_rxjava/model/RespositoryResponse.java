package com.example.mvp_dagger_rxjava.model;

import java.io.Serializable;
import java.util.List;

public class RespositoryResponse implements Serializable {
    private boolean incomplete_results;
    private int total_count;
    private List<Repository> items;

    public RespositoryResponse(boolean incomplete_results, int total_count, List<Repository> item) {
        this.incomplete_results = incomplete_results;
        this.total_count = total_count;
        this.items = item;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public int getTotal_count() {
        return total_count;
    }

    public List<Repository> getItems() {
        return items;
    }
}
