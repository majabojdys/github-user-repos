package com.bojdys.github.user.fetcher.github.client;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GitHubRepository {

    private String name;
    private GitHubOwner owner;
    private Boolean fork;

    @JsonCreator
    public GitHubRepository(String name, GitHubOwner owner, Boolean fork) {
        this.name = name;
        this.owner = owner;
        this.fork = fork;
    }

    public String getName() {
        return name;
    }

    public GitHubOwner getOwner() {
        return owner;
    }

    public Boolean getFork() {
        return fork;
    }

}
