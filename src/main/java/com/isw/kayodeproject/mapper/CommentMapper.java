package com.isw.kayodeproject.mapper;

import com.isw.kayodeproject.dto.CommentDto;
import com.isw.kayodeproject.entity.Comment;

public class CommentMapper {

    // convert comment entity to comment dto
    public static CommentDto mapToCommentDto(Comment comment){
        return CommentDto.builder()
                .id(comment.getId())
                .title(comment.getTitle())
//                .name(comment.getName())
//                .email(comment.getEmail())
                .content(comment.getContent())
                .createdOn(comment.getCreatedOn())
                .updatedOn(comment.getUpdatedOn())
                .upVotes(comment.getUpVotes())
                .downVotes(comment.getDownVotes())
                .user(comment.getUser())
                .post(comment.getPost())
                .build();
    }

    // convert comment dto to comment entity
    public static Comment mapToComment(CommentDto commentDto){
        return Comment.builder()
                .id(commentDto.getId())
                .title(commentDto.getTitle())
//                .name(commentDto.getName())
//                .email(commentDto.getEmail())
                .content(commentDto.getContent())
                .createdOn(commentDto.getCreatedOn())
                .updatedOn(commentDto.getUpdatedOn())
                .upVotes(commentDto.getUpVotes())
                .downVotes(commentDto.getDownVotes())
                .user(commentDto.getUser())
                .post(commentDto.getPost())
                .build();
    }
}