package com.isw.kayodeproject.mapper;

import com.isw.kayodeproject.dto.PostDto;
import com.isw.kayodeproject.entity.Post;

import java.util.stream.Collectors;

public class PostMapper {

    // convert Post entity to PostDto so it can be displayed on the view
    public static PostDto mapToPostDto(Post post){
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .url(post.getUrl())
                .content(post.getContent())
                .shortDescription(post.getShortDescription())
                .createdOn(post.getCreatedOn())
                .updatedOn(post.getUpdatedOn())
                .comments(post.getComments().stream()
                        .map((comment) -> CommentMapper.mapToCommentDto(comment))
                        .collect(Collectors.toSet())) // .toSet method collects the result in a set
                .build();
    }

    // convert  PostDto to Post entity, so it can be stored in the db
    public static Post mapToPost(PostDto postDto){
        return Post.builder()
                .id(postDto.getId())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .url(postDto.getUrl())
                .shortDescription(postDto.getShortDescription())
                .createdOn(postDto.getCreatedOn())
                .updatedOn(postDto.getUpdatedOn())
                .build();
    }
}
