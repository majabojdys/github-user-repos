package com.bojdys.github.user.fetcher.github.client;

import com.bojdys.github.user.fetcher.github.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
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
        try {
            ResponseEntity <GitHubRepository[]> repos = restTemplate.getForEntity("https://api.github.com/users/" + username + "/repos", GitHubRepository[].class);
            return Arrays.asList(repos.getBody());
        }
        catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new UserNotFoundException("User: " + username + " not found");
            }
            throw e;
        }
    }

}
