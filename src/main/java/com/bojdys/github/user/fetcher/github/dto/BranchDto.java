package com.bojdys.github.user.fetcher.github.dto;

import java.util.Objects;

public class BranchDto {

    private String name;
    private String sha;

    public BranchDto(String name, String sha) {
        this.name = name;
        this.sha = sha;
    }

    public String getName() {
        return name;
    }

    public String getSha() {
        return sha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BranchDto branchDto = (BranchDto) o;
        return Objects.equals(name, branchDto.name) && Objects.equals(sha, branchDto.sha);
    }

}
