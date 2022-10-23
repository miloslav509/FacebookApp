package com.facebook.support;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.facebook.dto.PostDTO;
import com.facebook.model.Post;
import com.facebook.service.PostService;
import com.facebook.service.UserService;

@Component
public class PostDtoToPost implements Converter<PostDTO, Post> {

	@Autowired
	private PostService service;
	
	@Autowired
	private UserService userService;

	@Override
	public Post convert(PostDTO dto) {
		Post post;
		
		if (dto.getId() != null) {
			post = service.findOne(dto.getId());
		} else {
			post = new Post();
		}
		
		if (post != null) {
			
			post.setDateTime(LocalDateTime.now().toString());
			post.setDescription(dto.getDescription());
			post.setLikesNumber(dto.getLikesNumber());
			post.setDislikesNumber(dto.getDislikesNumber());
			post.setPicturePath(dto.getPicturePath());
			post.setVideoPath(dto.getVideoPath());
			post.setViews(dto.getViews());
		}
		
		return post;
	}
	
	
}
