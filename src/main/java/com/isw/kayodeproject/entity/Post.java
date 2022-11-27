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

        //mappedBy value is in the comment entity. This is what maps the relationships
    // Cascade is used in the sense that whatever happens in the parent entity should also happen
    // to all other entities dependent on it, so if the post is deleted, all the comments set
    // under it should be deleted too
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private Set<Comment> comments = new HashSet<>();

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    //Implement uuid here
//    private Long id;
//
//    @Column(nullable = false)
//    private String title;
//
//    private String url;
//
//    @Lob
//    @Column(nullable = false)
//    private String content;
//    private String shortDescription;
//
//    @CreationTimestamp
//    private LocalDateTime createdOn;
//
//    @UpdateTimestamp
//    private LocalDateTime updatedOn;
//
//    @ManyToOne
//    @JoinColumn(name = "created_by", referencedColumnName = "id", nullable = false)
//    private User createdBy;  // how will I map this to author?
//
//    @ManyToOne
//    @JoinColumn(name = "posts", referencedColumnName = "id", nullable = false)
//    private SubjectTopic subjectTopic;
//
//

}
