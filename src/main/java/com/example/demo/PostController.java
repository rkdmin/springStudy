package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    private final PostService postService;

    // 생성자 주입
    // 명확한 의도이기 때문에 @Autowired 생략 가능
    public PostController(PostService postService) {
        this.postService = postService;
    }

    public String createPost(){
        return postService.createPost();
    }
}
