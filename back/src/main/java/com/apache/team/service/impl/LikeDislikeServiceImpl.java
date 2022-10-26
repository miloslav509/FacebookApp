package com.apache.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.team.model.LikeDislike;
import com.apache.team.repository.LikeDislikeRepository;
import com.apache.team.service.LikeDislikeService;



@Service
public class LikeDislikeServiceImpl implements LikeDislikeService {

	@Autowired
	private LikeDislikeRepository repository;

	@Override
	public LikeDislike findOne(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public List<LikeDislike> findAll() {
		
		return repository.findAll();
	}

	@Override
	public LikeDislike save(LikeDislike likeDislike) {
		
		return repository.save(likeDislike);
	}

	@Override
	public LikeDislike delete(Long id) {
		LikeDislike like = findOne(id);
		if (like != null) {
			repository.deleteById(id);
			return like;
		}
		return null;
	}
	
	
}
