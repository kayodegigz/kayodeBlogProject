package com.isw.kayodeproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Implement uuid here
    private Long id;
    @Column(nullable = false)
    private String title;
    private String url;

    @Lob
    @Column(nullable = false)
    private String content;
    private String shortDescription;

    @CreationTimestamp
    private LocalDateTime createdOn;

    @UpdateTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "name", nullable = false)
    private Users createdBy;  // how will I map this to author?


    //mappedBy value is in the comment entity. This is what maps the relationships
    // Cascade is used in the sense that whatever happens in this entity should also happen
    // to all other entities dependent on it, so if this post is deleted, all the comments
    // under it should be deleted too
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();
}
