package com.bojdys.github.user.fetcher.github;

import com.bojdys.github.user.fetcher.github.dto.RepositoryDtoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoint {

    private UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/{username}")
    public List<RepositoryDtoResponse> getAllRepos(@PathVariable String username){
        return userService.getRepos(username);
    }

}
