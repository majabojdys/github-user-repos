package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.client.*;
import com.bojdys.github.user.fetcher.github.dto.BranchDto;
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
        GitHubCommit gitHubCommit = new GitHubCommit("xyz");
        GitHubBranch branch1 = new GitHubBranch("name1", gitHubCommit);
        GitHubBranch branch2 = new GitHubBranch("name2", gitHubCommit);
        Mockito.when(gitHubUserClient.getUserRepositories(username)).thenReturn(List.of(gitHubRepository1, gitHubRepository2));
        Mockito.when(gitHubUserClient.getRepoBranches(username, "repo2")).thenReturn(List.of(branch1, branch2));

        //when
        List<RepositoryDtoResponse> result = userService.getRepos(username);

        //then
        BranchDto branchDto1 = new BranchDto(branch1.getName(), branch1.getCommit().getSha());
        BranchDto branchDto2 = new BranchDto(branch2.getName(), branch2.getCommit().getSha());
        RepositoryDtoResponse repositoryDtoResponse = new RepositoryDtoResponse("repo2", username, List.of(branchDto1, branchDto2));
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(repositoryDtoResponse, result.get(0));
    }


}
