package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.client.GitHubBranch;
import com.bojdys.github.user.fetcher.github.client.GitHubUserClient;
import com.bojdys.github.user.fetcher.github.dto.BranchDto;
import com.bojdys.github.user.fetcher.github.dto.RepositoryDtoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private GitHubUserClient gitHubUserClient;

    public UserService(GitHubUserClient gitHubUserClient) {
        this.gitHubUserClient = gitHubUserClient;
    }

    public List<RepositoryDtoResponse> getRepos(String username){
        return gitHubUserClient.getUserRepositories(username).parallelStream()
                .filter(r -> !r.getFork())
                .map(r -> new RepositoryDtoResponse(r.getName(), r.getOwner().getLogin(), getBranches(username, r.getName())))
                .toList();
    }

    private List<BranchDto> getBranches(String username, String repoName){
        return gitHubUserClient.getRepoBranches(username, repoName).stream()
                .map(b -> new BranchDto(b.getName(), b.getCommit().getSha()))
                .toList();
    }

}
