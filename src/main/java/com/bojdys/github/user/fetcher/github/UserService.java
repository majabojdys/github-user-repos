package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.client.GitHubUserClient;
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
        return gitHubUserClient.getUserRepositories(username).stream()
                .filter(r -> !r.getFork())
                .map(r -> new RepositoryDtoResponse(r.getName(), r.getOwner().getLogin()))
                .toList();
    }
}
