package com.apache.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.apache.team.model.LikeDislike;



@Component
public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {

}
