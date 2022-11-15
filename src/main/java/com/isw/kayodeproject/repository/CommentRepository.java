package com.isw.kayodeproject.repository;

import com.isw.kayodeproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//We don't have to use @Repository annotation here, JpaRepository does all behind the scenes
// We also do not have to use @Transactional annotation to make all d methods transactional
// Cos all public methods in SimpleJparepository by default are annotated with @Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select c.* from comments c inner join posts p\n" +
            "where c.post_id = p.id and p.created_by =:userId", nativeQuery = true)
    List<Comment> findCommentsByPost(Long userId);
}
