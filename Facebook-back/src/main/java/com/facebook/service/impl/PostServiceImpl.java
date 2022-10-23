package com.facebook.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.facebook.model.Post;
import com.facebook.repository.PostRepository;
import com.facebook.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository repository;

	@Override
	public List<Post> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Page<Post> findAll(int pageNo) {
		
		return repository.findAll(PageRequest.of(pageNo, 3));
	}

	@Override
	public Post findOne(Long id) {

		return repository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		
		return repository.save(post);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
		
	}
	
	
}
