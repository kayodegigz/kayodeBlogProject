package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.CommentDto;
import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.service.CommentService;
import com.isw.kayodeproject.service.PostService;
//import com.isw.kayodeproject.util.SecurityUtills;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    private PostService postService; //the controller talks to the service and not the repo directly
    private CommentService commentService;

    public PostController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/")
    public String landingPage() {
//        return "/users/login.html";
        return "/generic/index";
    }

    // create handler method, GET request and return model and view
    @GetMapping("/admin/posts")
    public String posts(Model model){
//        String role = SecurityUtils.getRole();
        List<PostDto> posts = null;
//        if(ROLE.ROLE_ADMIN.name().equals(role)){
            posts = postService.findAllPosts();
//        }
//        else{
//            posts = postService.findPostsByUser();
//        }
        model.addAttribute("posts", posts);
        return "/admin/posts";
    }



    // handler method to handle list comments request
    @GetMapping("/admin/posts/comments") // this is an endpoint
    public String postComments(Model model){
//        String role = SecurityUtils.getRole();
        List<CommentDto> comments = null;
//        if(ROLE.ROLE_ADMIN.name().equals(role)){
            comments = commentService.findAllComments();
//        }
//        else{
//            comments = commentService.findCommentsByPost();
//        }
        model.addAttribute("comments", comments);
        return "admin/comments";
    }

    // handler method to handle delete comment request
    @GetMapping("/admin/posts/comments/{commentId}") // this is another endpoint, they are all endpoints!
    public String deleteComment(@PathVariable("commentId") Long commentId){
        commentService.deleteComment(commentId);
        return "redirect:/admin/posts/comments";
    }

    // handler method to handle new post request
    @GetMapping("/users/posts/newpost")
    public String newPostForm(Model model){
        PostDto postDto = new PostDto();
        model.addAttribute("post", postDto);
        return "/users/createPost";
//        return "admin/create_post";
    }

    // handler method to handle form submit request
    @PostMapping("/users/posts")
    //@ModelAttribute maps the input from the form to @the Model
    public String createPost(@Valid @ModelAttribute("post") PostDto postDto,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("post", postDto);
            return "/users/createPost"; // If an error occurred, show the create post page again
//            return "admin/create_post";
        }
        //  setter method for url attr of postdto
        // and getUrl is defined below
        postDto.setUrl(getUrl(postDto.getTitle()));
        postService.createPost(postDto);
        return "redirect:/users/posts/newpost?success"; // made a mistake of redirecting to a post mapping endpoint instead of a get one
    }

    // handler method to handle edit post request
    @GetMapping("/admin/posts/{postId}/edit")
    public String editPostForm(@PathVariable("postId") Long postId,
                               Model model){

        PostDto postDto = postService.findPostById(postId);
        model.addAttribute("post", postDto);
        return "/admin/posts";
//        return "admin/edit_post";
    }

    // handler method to handle edit post form submit request
    @PostMapping("/admin/posts/{postId}")
    public String updatePost(@PathVariable("postId") Long postId,
                             @Valid @ModelAttribute("post") PostDto post,
                             BindingResult result,
                             Model model){
        if(result.hasErrors()){
            model.addAttribute("post", post);
            return "/admin/posts";
//            return "admin/edit_post";
        }

        post.setId(postId);
        postService.updatePost(post);
        return "redirect:/admin/posts";
    }

    // handler method to handle delete post request
    @GetMapping("/admin/posts/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return "redirect:/admin/posts";
    }


    // handler method to handle view post request
    @GetMapping("/users/posts/{postUrl}/view")
    public String viewPost(@PathVariable("postUrl") String postUrl,
                           Model model){
        PostDto postDto = postService.findPostByUrl(postUrl);
        model.addAttribute("post", postDto);
        return "users/viewPost";
//        return "admin/view_post";

    }

    // handler method to handle search blog posts request
    // localhost:8080/admin/posts/search?query=java(for example)
    @GetMapping("/admin/posts/search")
    public String searchPosts(@RequestParam(value = "query") String query,
                              Model model){
        List<PostDto> posts = postService.searchPosts(query);
        model.addAttribute("posts", posts);
        return "admin/posts";
    }

    private static String getUrl(String postTitle){
        // OOPS Concepts Explained in Java
        // oops-concepts-explained-in-java
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s+", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }
}