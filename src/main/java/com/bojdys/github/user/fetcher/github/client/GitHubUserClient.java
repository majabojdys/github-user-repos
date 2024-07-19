package com.bojdys.github.user.fetcher.github.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GitHubUserClient {

    private RestTemplate restTemplate;

    public GitHubUserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<GitHubRepository> getUserRepositories(String username){
        GitHubRepository[] repos = restTemplate.getForObject("https://api.github.com/users/" + username + "/repos", GitHubRepository[].class);
        return Arrays.asList(repos);
    }

}
