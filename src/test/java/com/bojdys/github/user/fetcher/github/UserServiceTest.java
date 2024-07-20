package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.client.GitHubOwner;
import com.bojdys.github.user.fetcher.github.client.GitHubRepository;
import com.bojdys.github.user.fetcher.github.client.GitHubUserClient;
import com.bojdys.github.user.fetcher.github.dto.RepositoryDtoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class UserServiceTest {

    private GitHubUserClient gitHubUserClient = Mockito.mock(GitHubUserClient.class);

    private UserService userService = new UserService(gitHubUserClient);

    @Test
    public void gettingNotForkReposTest(){
        //given
        String username = "majabojdys";
        GitHubOwner gitHubOwner = new GitHubOwner(username);
        GitHubRepository gitHubRepository1 = new GitHubRepository("repo1", gitHubOwner, true );
        GitHubRepository gitHubRepository2 = new GitHubRepository("repo2", gitHubOwner, false);
        Mockito.when(gitHubUserClient.getUserRepositories(username)).thenReturn(List.of(gitHubRepository1, gitHubRepository2));

        //when
        List<RepositoryDtoResponse> result = userService.getRepos(username);

        //then
        RepositoryDtoResponse repositoryDtoResponse = new RepositoryDtoResponse("repo2", username);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(repositoryDtoResponse, result.get(0));
    }


}
