package com.isw.kayodeproject.service.impl;

import com.isw.kayodeproject.dto.CommentDto;
import com.isw.kayodeproject.entity.Comment;
import com.isw.kayodeproject.entity.Post;
import com.isw.kayodeproject.entity.Users;
import com.isw.kayodeproject.mapper.CommentMapper;
import com.isw.kayodeproject.repository.CommentRepository;
import com.isw.kayodeproject.repository.PostRepository;
import com.isw.kayodeproject.repository.UserRepository;
import com.isw.kayodeproject.service.CommentService;
import com.isw.kayodeproject.util.SecurityUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createComment(String postUrl, CommentDto commentDto) {

        Post post = postRepository.findByUrl(postUrl).get();
        Comment comment = CommentMapper.mapToComment(commentDto); //cnvrt d comment comin frm d view to entity obj
        comment.setPost(post); //setter method in Comment Entity to bind it to a post
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDto> findAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(CommentMapper::mapToCommentDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDto> findCommentsByPost() {
        String email = SecurityUtils.getCurrentUser().getUsername();
        Users createdBy = userRepository.findByEmail(email);
        Long userId = createdBy.getId();
        List<Comment> comments = commentRepository.findCommentsByPost(userId);
        return comments.stream()
                .map((comment) -> CommentMapper.mapToCommentDto(comment))
                .collect(Collectors.toList());
    }
}
