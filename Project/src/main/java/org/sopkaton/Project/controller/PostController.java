package org.sopkaton.Project.controller;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.common.ApiResponse;
import org.sopkaton.Project.service.PostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.sopkaton.Project.common.dto.Success;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/{ssaId}/posts")
    public ApiResponse getPostsByUser(@PathVariable String ssaId) {
        return ApiResponse.success(Success.GET_POST_SUCCESS, postService.getPostsByUser(ssaId));
    }

    @PostMapping("/{ssaId}/post")
    public ApiResponse createPost(@PathVariable String ssaId,
                                  @RequestPart String postContent,
                                  @RequestPart MultipartFile postImg) throws Exception {
        return ApiResponse.success(Success.CREATE_POST_SUCCESS, postService.createPost(ssaId, postContent, postImg));
    }
}
