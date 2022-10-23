package com.facebook.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.facebook.model.Post;

public interface PostService {

	public List<Post> findAll();
	public Page<Post> findAll(int pageNo);
	public Post findOne(Long id);
	public Post save(Post post);
	public void delete(Long id);
}
