package org.sopkaton.Project.controller;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.common.ApiResponse;
import org.sopkaton.Project.dto.response.UserGetResponse;
import org.sopkaton.Project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sopkaton.Project.common.dto.Success;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login/{ssaId}")
    public ApiResponse<UserGetResponse> login(@PathVariable String ssaId) {
        return ApiResponse.success(Success.CREATE_SUCCESS,userService.login(ssaId));
    }


}
