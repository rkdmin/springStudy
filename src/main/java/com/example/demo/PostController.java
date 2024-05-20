package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    // 생성자 주입
    // 명확한 의도이기 때문에 @Autowired 생략 가능
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String getPost(){
        return postService.getPost();
    }
}
