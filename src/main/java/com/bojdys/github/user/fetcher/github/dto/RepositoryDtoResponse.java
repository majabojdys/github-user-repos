package com.bojdys.github.user.fetcher.github.dto;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryDtoResponse that = (RepositoryDtoResponse) o;
        return Objects.equals(repositoryName, that.repositoryName) && Objects.equals(ownerLogin, that.ownerLogin);
    }

}
