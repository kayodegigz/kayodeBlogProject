package com.isw.kayodeproject.controller;

import com.isw.kayodeproject.dto.CommentDto;
import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.service.CommentService;
import com.isw.kayodeproject.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CommentController {

    private CommentService commentService;
    private PostService postService;

    public CommentController(CommentService commentService, PostService postService) {
        this.commentService = commentService;
        this.postService = postService;
    }

    // handler method to create form submit request
    @PostMapping("/{postUrl}/comments")
    public String createComment(@PathVariable("postUrl") String postUrl,
                                @Valid @ModelAttribute("comment") CommentDto commentDto,
                                BindingResult result,
                                Model model){

        PostDto postDto = postService.findPostByUrl(postUrl);
        if(result.hasErrors()){ // result id a bindingRes object, it has a predefined has errors method
            model.addAttribute("post", postDto);
            model.addAttribute("comment", commentDto);
            return "/admin/posts";
//            return "blog/blog_post";
        }

        commentService.createComment(postUrl, commentDto);
        return "redirect:/post/" + postUrl; //passing the post url dynamically
    }
}
