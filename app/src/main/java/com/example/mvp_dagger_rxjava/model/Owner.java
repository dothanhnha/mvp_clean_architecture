package com.example.mvp_dagger_rxjava.model;

import java.io.Serializable;

public class Owner implements Serializable {
    private String avatar_url;
    private String events_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String gravatar_id;
    private String html_url;
    private String id;
    private String login;
    private String node_id;
    private String organizations_url;
    private String received_events_url;
    private String repos_url;
    private String site_admin;
    private String starred_url;
    private String subscriptions_url;
    private String type;
    private String url;

    public Owner(String avatar_url, String events_url, String followers_url, String following_url,
                 String gists_url, String gravatar_id, String html_url, String id, String login,
                 String node_id, String organizations_url, String received_events_url,
                 String repos_url, String site_admin, String starred_url, String subscriptions_url,
                 String type, String url) {
        this.avatar_url = avatar_url;
        this.events_url = events_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.gravatar_id = gravatar_id;
        this.html_url = html_url;
        this.id = id;
        this.login = login;
        this.node_id = node_id;
        this.organizations_url = organizations_url;
        this.received_events_url = received_events_url;
        this.repos_url = repos_url;
        this.site_admin = site_admin;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.type = type;
        this.url = url;
    }
}


