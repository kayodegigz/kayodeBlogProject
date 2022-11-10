package com.isw.kayodeproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
@Entity
public class Post {

    @Id
    //Implement uuid here
    private Long id;
    @Column(nullable = false)
    private String title;
    private String url;

    @Lob //Make the text more than varchar(250)
    @Column(nullable = false)
    private String content;
    private String shortDescription;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;
}
