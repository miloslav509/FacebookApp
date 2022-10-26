package com.apache.team.service;

import java.util.List;

import com.apache.team.model.Comment;

public interface CommentService {

	List<Comment> getAll();
	Comment getOne(Long id);
	Comment create(Comment comment);
	void delete(Long id);
}
