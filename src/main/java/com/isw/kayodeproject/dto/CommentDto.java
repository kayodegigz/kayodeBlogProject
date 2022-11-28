package com.isw.kayodeproject.dto;

import com.isw.kayodeproject.entity.Post;
import com.isw.kayodeproject.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    private Long id;

    @NotEmpty(message = "Type in a comment before you submit")
    private String content;
//    @NotEmpty(message = "Email should not be empty or null")
//    @Email
//    private String email;
//    @NotEmpty(message = "Message body should not be empty")
//    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Post post; //postId??? Why not?
    private Long upVotes;
    private Long downVotes;
    private User created_by;
}
