package com.apache.team.support;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.apache.team.dto.PostDTO;
import com.apache.team.model.Post;
import com.apache.team.service.PostService;
import com.apache.team.service.UserService;



@Component
public class PostDtoToPost implements Converter<PostDTO, Post> {

	@Autowired
	private PostService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeDislikeDtoToLikeDislike toLikeDislike;

	@Override
	public Post convert(PostDTO dto) {
		Post post;
		
		if (dto.getId() != null) {
			post = service.findOne(dto.getId());
		} else {
			post = new Post();
		}
		
		if (post != null) {
			
			post.setDateTime(formatDate(LocalDateTime.now().toString()));
			post.setDescription(dto.getDescription());
			post.setLikesDislikes(toLikeDislike.convert(dto.getLikesDislikes()));
			post.setPicturePath(dto.getPicturePath());
			post.setVideoPath(dto.getVideoPath());
			post.setViews(dto.getViews());
			post.setUser(userService.findByUsername(dto.getUsername()));
		}
		
		return post;
	}
	
	public String formatDate(String string) {
		string = string.substring(0, 16);
		
		return string.replace('T', ' ');
	}
	
	
}
