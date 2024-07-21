package com.bojdys.github.user.fetcher.github.client;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GitHubCommit {

    private String sha;

    @JsonCreator
    public GitHubCommit(String sha) {
        this.sha = sha;
    }

    public String getSha() {
        return sha;
    }
}
