package com.isw.kayodeproject.repository;

import com.isw.kayodeproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

//We don't have to use @Repository annotation here, JpaRepository does all behind the scenes
// We also do not have to use @Transactional annotation to make all d methods transactional
// Cos all public methods in SimpleJparepository by default are annotated with @Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
