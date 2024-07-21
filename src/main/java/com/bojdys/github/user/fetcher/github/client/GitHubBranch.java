package com.bojdys.github.user.fetcher.github.client;

import com.fasterxml.jackson.annotation.JsonCreator;

public class GitHubBranch {

    private String name;
    private GitHubCommit commit;

    @JsonCreator
    public GitHubBranch(String name, GitHubCommit commit) {
        this.name = name;
        this.commit = commit;
    }

    public String getName() {
        return name;
    }

    public GitHubCommit getCommit() {
        return commit;
    }
}
