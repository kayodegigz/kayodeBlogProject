package com.isw.kayodeproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String id;
    // adds the not empty validation
    @NotEmpty(message = "Post title should not be empty")
    private String title;
    private String url;
    @NotEmpty(message = "Post content should not be empty")
    private String content;
    @NotEmpty(message = "Post short description should not be empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Set<CommentDto> comments; //set of commentDto objects to be displayed
    private User createdBy; // or useerdto?
}