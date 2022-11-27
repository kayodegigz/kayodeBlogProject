package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.CommentDto;
import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    // handles the requests for the blog content

    private PostService postService;

    //constructor based dependency injection,(recommended)
    public BlogController(PostService postService) {
        this.postService = postService;
    }

    // handler method to handle http://localhost:8080/(root)
    @GetMapping("/blog")  // resolve this to blog home page
    public String viewBlogPosts(Model model){
        List<PostDto> postsResponse = postService.findAllPosts();
        model.addAttribute("postsResponse", postsResponse);
        return "/users/blog";
//        return "blog/view_posts";
    }

    // handler method to handle view post request
    @GetMapping("/post/{postUrl}")
    private String showPost(@PathVariable("postUrl") String postUrl,
                            Model model){
        PostDto post = postService.findPostByUrl(postUrl);

        CommentDto commentDto = new CommentDto();
        model.addAttribute("post", post);
        model.addAttribute("comment", commentDto);
        return "/admin/posts";
//        return "blog/blog_post";
    }

    // handler method to handle blog post search request
    // http://localhost:8080/page/search?query=java
    @GetMapping("/blog/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        //@RequestParam is used to get the query string from the request body
        List<PostDto> postsResponse = postService.searchPosts(query);
        model.addAttribute("postsResponse", postsResponse);
        return "/users/blog";
//        return "blog/view_posts";
    }
}
