package com.isw.kayodeproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")  // customizing the table name so it won't be the default name(which is the original entity name)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // means auto generate
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    // mapped by is the name of the instance in the many to one end
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.REMOVE)
    private List<Post> posts;

    // cascade means all the actions performed on users should be performed on the corresponding role
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) // To load a list of roles immediately user loads
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();
    private String occupation;
    private Date dob;  // ask gb how to convert it to age
    private Date dateJoined;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Comment> comment;
}

