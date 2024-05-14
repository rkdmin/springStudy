package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    public Post getPost() {
        Post post = new Post();
        post.setTitle("게시글 제목입니다.");
        post.setContent("게시글 내용입니다.");

        return post;
    }

    public Post createPost(Post post) {
        return post;
    }

    public Post updatePost(Long id, Post post) {
        post.setId(3L);
        return post;
    }

    public Post editPost(Long id, Post post) {
        post.setId(3L);
        post.setContent("게시글 내용입니다.");
        return post;
    }

    public Post deletePost(Long id) {
        Post post = new Post();
        post.setId(3L);
        post.setTitle("게시글 제목입니다.");
        post.setContent("게시글 내용입니다.");

        return post;
    }
}
