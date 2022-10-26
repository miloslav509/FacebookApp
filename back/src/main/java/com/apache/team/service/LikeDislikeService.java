package com.apache.team.service;

import java.util.List;

import com.apache.team.model.LikeDislike;



public interface LikeDislikeService {

	LikeDislike findOne(Long id);
	
	List<LikeDislike> findAll();
	
	LikeDislike save(LikeDislike likeDislike);
	
	LikeDislike delete(Long id);
}
