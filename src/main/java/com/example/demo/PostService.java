package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    // 생성자 주입
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String createPost(){ return  postRepository.createPost(); };
}
