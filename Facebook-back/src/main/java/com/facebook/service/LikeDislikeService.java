package com.facebook.service;

import java.util.List;

import com.facebook.model.LikeDislike;

public interface LikeDislikeService {

	LikeDislike findOne(Long id);
	
	List<LikeDislike> findAll();
	
	LikeDislike save(LikeDislike likeDislike);
	
	LikeDislike delete(Long id);
}
