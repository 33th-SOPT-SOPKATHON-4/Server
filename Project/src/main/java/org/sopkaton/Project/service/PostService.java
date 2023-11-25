package org.sopkaton.Project.service;

import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.external.S3Service;
import org.sopkaton.Project.repository.PostRepository;
import org.sopkaton.Project.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final S3Service s3Service;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(String ssaId, String postContent, MultipartFile postImg) throws Exception {
        String imgUrl = s3Service.uploadImage("post/", postImg);
        String createdDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Post post = Post.builder()
                .postImg(imgUrl)
                .postContent(postContent)
                .postDislikeCount(0)
                .createdDateTime(createdDateTime)
                .user(userRepository.findById(ssaId).get())
                .build();

        postRepository.save(post);

        return post;
    }

    public List<Post> getPostsByUser(String ssaId) {
        return postRepository.findByUser(userRepository.findById(ssaId).get());
    }
}
