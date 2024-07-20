package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.client.GitHubOwner;
import com.bojdys.github.user.fetcher.github.client.GitHubRepository;
import com.bojdys.github.user.fetcher.github.dto.ExceptionDtoResponse;
import com.bojdys.github.user.fetcher.github.dto.RepositoryDtoResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

public class UserIntegrationTest extends IntegrationTest {

    @Test
    public void getUserReposSuccessIntegrationTest() {
        //given
        String username = "majabojdys";
        String githubUrl = "https://api.github.com/users/" + username + "/repos";
        String gitHubResponse = """
                [
                    {
                        "name": "repo1",
                        "owner": {
                             "login": "majabojdys"
                         },
                        "fork": false
                   }
                ]
                """;
        mockServer.expect(requestTo(githubUrl))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(gitHubResponse, MediaType.APPLICATION_JSON));

        //when
        ResponseEntity<RepositoryDtoResponse[]> result = testRestTemplate.getForEntity(getLocalhost() + "/users/" + username, RepositoryDtoResponse[].class);

        //then
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        RepositoryDtoResponse[] resultBody = result.getBody();

        Assertions.assertEquals(1, resultBody.length);
        Assertions.assertEquals(username, resultBody[0].getOwnerLogin());
        Assertions.assertEquals("repo1", resultBody[0].getRepositoryName());
    }

    @Test
    public void userNotFoundIntegrationTest() {
        //given
        String username = "majabojdys";
        String githubUrl = "https://api.github.com/users/" + username + "/repos";
        mockServer.expect(requestTo(githubUrl))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withRawStatus(404));

        //when
        ResponseEntity<ExceptionDtoResponse> result = testRestTemplate.getForEntity(getLocalhost() + "/users/" + username, ExceptionDtoResponse.class);

        //then
        Assertions.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
        ExceptionDtoResponse body = result.getBody();

        Assertions.assertEquals(404, body.getStatus());
        Assertions.assertEquals("User: majabojdys not found", body.getMessage());
    }
}
