package com.bojdys.github.user.fetcher.github.dto;

public class RepositoryDtoResponse {

    private String repositoryName;
    private String ownerLogin;

    public RepositoryDtoResponse(String repositoryName, String ownerLogin) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

}
