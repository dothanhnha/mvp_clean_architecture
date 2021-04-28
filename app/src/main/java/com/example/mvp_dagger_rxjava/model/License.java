package com.example.mvp_dagger_rxjava.model;

import java.io.Serializable;

public class License implements Serializable {
    private String key;
    private String name;
    private String node_id;
    private String spdx_id;
    private String url;

    public License(String key, String name, String node_id, String spdx_id, String url) {
        this.key = key;
        this.name = name;
        this.node_id = node_id;
        this.spdx_id = spdx_id;
        this.url = url;
    }
}
