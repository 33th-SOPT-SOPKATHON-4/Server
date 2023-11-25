package org.sopkaton.Project.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.sopkaton.Project.domain.Post;
import org.sopkaton.Project.domain.User;
import org.sopkaton.Project.domain.UserPostInteractions;
import org.sopkaton.Project.dto.response.PostGetResponse;
import org.sopkaton.Project.external.S3Service;
import org.sopkaton.Project.repository.PostRepository;
import org.sopkaton.Project.repository.UserPostInteractionsRepository;
import org.sopkaton.Project.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PostService {

    private final S3Service s3Service;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserPostInteractionsRepository userPostInteractionsRepository;

    Random random = new Random();

    public PostGetResponse createPost(String ssaId, String postContent, MultipartFile postImg) throws Exception {
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

        return PostGetResponse.of(post);
    }

    public List<PostGetResponse> getPostsByUser(String ssaId) {
        ArrayList<Post> postList = new ArrayList<>();
        List<Post> randomPostList = getRandomPostId(ssaId);

        for (Post randomPost : randomPostList){
            Post post = postRepository.findById(randomPost.getPostId()).orElseThrow( () -> new EntityNotFoundException("없는 게시물입니다."));
            postList.add(post);
        }

        return postList.stream().map(PostGetResponse::of).toList();
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

    private ArrayList<Post> getRandomPostId(String ssaId){
        ArrayList<Post> randomPostList = new ArrayList<>();

        List<Post> post = postRepository.findAll();

        List<Post> userPostIdList = postRepository.findPostIdByUser(userRepository.findById(ssaId).get());
        List<Long> dislikePostList = userPostInteractionsRepository.findDislikePostByUser(ssaId);

        while(randomPostList.size()<12){
            int randomInt = random.nextInt(post.size())+1;
            if (!userPostIdList.contains(post.get(randomInt)) && !randomPostList.contains(post.get(randomInt))
                    &&!dislikePostList.contains(post.get(randomInt).getPostId())) {
                randomPostList.add(post.get(randomInt));
            }
        }

        return randomPostList;
    }

}
