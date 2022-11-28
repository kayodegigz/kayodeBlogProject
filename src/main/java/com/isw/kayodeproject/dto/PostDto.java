package com.isw.kayodeproject.dto;

import com.isw.kayodeproject.entity.SubjectTopic;
import com.isw.kayodeproject.entity.User;
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

    private Long id;
    @NotEmpty(message = "Post title should not be empty")
    private String title;
    private String url;
    @NotEmpty(message = "Post content should not be empty")
    private String content;
    @NotEmpty(message = "Post short description should be empty")
    private String shortDescription;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private User created_by;
    private Set<CommentDto> comments; //set of commentDto objects to be displayed

    private Long upVotes;

    private Long downVotes;



//    private Long id;
//    // adds the not empty validation
//    @NotEmpty(message = "Post title should not be empty")
//    private String title;
//    private String url;
//    @NotEmpty(message = "Post content should not be empty")
//    private String content;
//    @NotEmpty(message = "Post short description should not be empty")
//    private String shortDescription;
//    private LocalDateTime createdOn;
//    private LocalDateTime updatedOn;
////    private User createdBy; // or userDto?
//    private SubjectTopic subjectTopic;
}
