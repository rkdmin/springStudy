package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 게시글 조회
    @GetMapping("/post")
    public Post getPost() {
        return postService.getPost();
    }

    // 게시글 생성
    @PostMapping("/post")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // 게시글 전체 수정
    @PutMapping("/post/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    // 게시글 일부 수정
    @PatchMapping("/post/{id}")
    public Post editPost(@PathVariable Long id, @RequestBody Post post) {
        return postService.editPost(id, post);
    }

    // 게시글 삭제
    @DeleteMapping("/post/{id}")
    public Post deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
