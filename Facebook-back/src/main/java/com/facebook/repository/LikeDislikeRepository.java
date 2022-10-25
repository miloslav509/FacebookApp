package com.facebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.facebook.model.LikeDislike;

@Component
public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {

}
