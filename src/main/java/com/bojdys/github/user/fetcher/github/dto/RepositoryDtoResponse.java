package com.bojdys.github.user.fetcher.github.dto;

import com.bojdys.github.user.fetcher.github.client.GitHubBranch;

import java.util.List;
import java.util.Objects;

public class RepositoryDtoResponse {

    private String repositoryName;
    private String ownerLogin;
    private List<BranchDto> branches;

    public RepositoryDtoResponse(String repositoryName, String ownerLogin, List<BranchDto> branches) {
        this.repositoryName = repositoryName;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public List<BranchDto> getBranches() {
        return branches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepositoryDtoResponse that = (RepositoryDtoResponse) o;
        return Objects.equals(repositoryName, that.repositoryName) && Objects.equals(ownerLogin, that.ownerLogin) && Objects.equals(branches, that.branches);
    }

}
