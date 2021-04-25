package com.example.mvp_dagger_rxjava.model;

import com.google.gson.annotations.SerializedName;

public class Repository {
    String archive_url;
    boolean archived;
    String assignees_url;
    String blobs_url;
    String branches_url;
    String clone_url;
    String collaborators_url;
    String comments_url;
    String commits_url;
    String compare_url;
    String contents_url;
    String contributors_url;
    String created_at;
    String default_branch;
    String deployments_url;
    String description;
    boolean disabled;
    String downloads_url;
    String events_url;
    boolean fork;
    int forks;
    int forks_count;
    String forks_url;
    String full_name;
    String git_commits_url;
    String git_refs_url;
    String git_tags_url;
    String git_url;
    boolean has_downloads;
    boolean has_issues;
    boolean has_pages;
    boolean has_projects;
    boolean has_wiki;
    String homepage;
    String hooks_url;
    String html_url;
    int id;
    String issue_comment_url;
    String issue_events_url;
    String issues_url;
    String keys_url;
    String labels_url;
    String language;
    String languages_url;
    License license;
    String merges_url;
    String milestones_url;
    String mirror_url;
    String name;
    String node_id;
    String notifications_url;
    int open_issues;
    int open_issues_count;
    Owner owner;
    @SerializedName("private")
    public boolean m_private;
    String pulls_url;
    String pushed_at;
    String releases_url;
    int score;
    int size;
    String ssh_url;
    int stargazers_count;
    String stargazers_url;
    String statuses_url;
    String subscribers_url;
    String subscription_url;
    String svn_url;
    String tags_url;
    String teams_url;
    String trees_url;
    String updated_at;
    String url;
    int watchers;
    int watchers_count;

    public Repository(String archive_url, boolean archived, String assignees_url, String blobs_url,
                      String branches_url, String clone_url, String collaborators_url,
                      String comments_url, String commits_url, String compare_url,
                      String contents_url, String contributors_url, String created_at,
                      String default_branch, String deployments_url, String description,
                      boolean disabled, String downloads_url, String events_url, boolean fork,
                      int forks, int forks_count, String forks_url, String full_name,
                      String git_commits_url, String git_refs_url, String git_tags_url,
                      String git_url, boolean has_downloads, boolean has_issues, boolean has_pages,
                      boolean has_projects, boolean has_wiki, String homepage, String hooks_url,
                      String html_url, int id, String issue_comment_url, String issue_events_url,
                      String issues_url, String keys_url, String labels_url, String language,
                      String languages_url, License license, String merges_url, String milestones_url,
                      String mirror_url, String name, String node_id, String notifications_url,
                      int open_issues, int open_issues_count, Owner owner, boolean m_private,
                      String pulls_url, String pushed_at, String releases_url, int score, int size,
                      String ssh_url, int stargazers_count, String stargazers_url, String statuses_url,
                      String subscribers_url, String subscription_url, String svn_url, String tags_url,
                      String teams_url, String trees_url, String updated_at, String url, int watchers,
                      int watchers_count) {
        this.archive_url = archive_url;
        this.archived = archived;
        this.assignees_url = assignees_url;
        this.blobs_url = blobs_url;
        this.branches_url = branches_url;
        this.clone_url = clone_url;
        this.collaborators_url = collaborators_url;
        this.comments_url = comments_url;
        this.commits_url = commits_url;
        this.compare_url = compare_url;
        this.contents_url = contents_url;
        this.contributors_url = contributors_url;
        this.created_at = created_at;
        this.default_branch = default_branch;
        this.deployments_url = deployments_url;
        this.description = description;
        this.disabled = disabled;
        this.downloads_url = downloads_url;
        this.events_url = events_url;
        this.fork = fork;
        this.forks = forks;
        this.forks_count = forks_count;
        this.forks_url = forks_url;
        this.full_name = full_name;
        this.git_commits_url = git_commits_url;
        this.git_refs_url = git_refs_url;
        this.git_tags_url = git_tags_url;
        this.git_url = git_url;
        this.has_downloads = has_downloads;
        this.has_issues = has_issues;
        this.has_pages = has_pages;
        this.has_projects = has_projects;
        this.has_wiki = has_wiki;
        this.homepage = homepage;
        this.hooks_url = hooks_url;
        this.html_url = html_url;
        this.id = id;
        this.issue_comment_url = issue_comment_url;
        this.issue_events_url = issue_events_url;
        this.issues_url = issues_url;
        this.keys_url = keys_url;
        this.labels_url = labels_url;
        this.language = language;
        this.languages_url = languages_url;
        this.license = license;
        this.merges_url = merges_url;
        this.milestones_url = milestones_url;
        this.mirror_url = mirror_url;
        this.name = name;
        this.node_id = node_id;
        this.notifications_url = notifications_url;
        this.open_issues = open_issues;
        this.open_issues_count = open_issues_count;
        this.owner = owner;
        this.m_private = m_private;
        this.pulls_url = pulls_url;
        this.pushed_at = pushed_at;
        this.releases_url = releases_url;
        this.score = score;
        this.size = size;
        this.ssh_url = ssh_url;
        this.stargazers_count = stargazers_count;
        this.stargazers_url = stargazers_url;
        this.statuses_url = statuses_url;
        this.subscribers_url = subscribers_url;
        this.subscription_url = subscription_url;
        this.svn_url = svn_url;
        this.tags_url = tags_url;
        this.teams_url = teams_url;
        this.trees_url = trees_url;
        this.updated_at = updated_at;
        this.url = url;
        this.watchers = watchers;
        this.watchers_count = watchers_count;
    }
}
