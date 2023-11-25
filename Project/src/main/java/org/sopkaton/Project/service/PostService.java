package org.sopkaton.Project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.domain.UserPostInteractions;
import org.sopkaton.Project.external.S3Service;
import org.sopkaton.Project.repository.PostRepository;
import org.sopkaton.Project.repository.UserPostInteractionsRepository;
import org.sopkaton.Project.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    private final UserPostInteractionsRepository userPostInteractionsRepository;

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

    @Transactional
    public void dislikePosts(String ssaId, List<Long> postIdList){
        for(Long postId : postIdList){
            postRepository.updateDislikeCount(postId);
            Post post = postRepository.findById(postId).orElseThrow(()-> new EntityNotFoundException("없는 게시물입니다."));
            userRepository.updateDislikeCount(post.getUser().getSsaId());
            UserPostInteractions postInteractions = userPostInteractionsRepository.save(UserPostInteractions.builder().postId(postId).ssaId(ssaId).build());
        }
    }
}
