package com.apache.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.apache.team.model.Comment;

@Component
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
