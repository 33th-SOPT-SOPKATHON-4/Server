package org.sopkaton.Project.controller;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.common.ApiResponse;
import org.sopkaton.Project.dto.response.UserGetResponse;
import org.sopkaton.Project.dto.response.UserPostGetResponse;
import org.sopkaton.Project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sopkaton.Project.common.dto.Success;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/login/{ssaId}")
    public ApiResponse<UserGetResponse> login(@PathVariable String ssaId) {
        return ApiResponse.success(Success.CREATE_USER_SUCCESS, userService.login(ssaId));
    }

    @GetMapping("/users/{ssaId}")
    public ApiResponse<UserPostGetResponse> getUserBySsaId(@PathVariable String ssaId) {
        return ApiResponse.success(Success.GET_USER_SUCCESS, userService.getUserBySsaId(ssaId));
    }
}
