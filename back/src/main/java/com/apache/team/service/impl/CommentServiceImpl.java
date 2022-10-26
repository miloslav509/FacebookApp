package com.apache.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apache.team.model.Comment;
import com.apache.team.repository.CommentRepository;
import com.apache.team.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository repository;

	@Override
	public List<Comment> getAll() {
		
		return repository.findAll();
	}

	@Override
	public Comment getOne(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public Comment create(Comment comment) {
		
		return repository.save(comment);
	}

	@Override
	public void delete(Long id) {
		Comment comment = getOne(id);
		
		if (comment != null) {
			repository.delete(comment);
		}
		
	}
	
	
}
