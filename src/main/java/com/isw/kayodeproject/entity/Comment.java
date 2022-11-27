package com.isw.kayodeproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments")
public class Comment {

    @Id // defines as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id",nullable = false) // so post_id is the name of the column that will be created
                                                    // here to hold content from the referencedColumn, which is the id
    private Post post; //postId??? Why not?

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User user;

    private Long upVotes;
    private Long downVotes;
}
