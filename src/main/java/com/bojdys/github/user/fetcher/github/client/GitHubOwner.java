package com.bojdys.github.user.fetcher.github.client;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GitHubOwner {

    private String login;

    @JsonCreator
    public GitHubOwner(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

}
