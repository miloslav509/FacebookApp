package com.apache.team.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.apache.team.model.Post;



@Component
public interface PostRepository extends JpaRepository<Post, Long> {

	Page<Post> findAll(Pageable pageable);
}
