package com.facebook.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.facebook.dto.PostDTO;
import com.facebook.model.Post;

@Component
public class PostToPostDto implements Converter<Post, PostDTO> {

	@Override
	public PostDTO convert(Post s) {
		PostDTO dto = new PostDTO();
		
		dto.setId(s.getId());
		dto.setDateTime(s.getDateTime());
		dto.setDescription(s.getDescription());
		dto.setLikesNumber(s.getLikesNumber());
		dto.setDislikesNumber(s.getDislikesNumber());
		dto.setPicturePath(s.getPicturePath());
		dto.setVideoPath(s.getVideoPath());
		dto.setViews(s.getViews());
		dto.setUsername(s.getUser().getUsername());
		
		return dto;
	}
	
	public List<PostDTO> convert(List<Post> posts) {
		List<PostDTO> dto = new ArrayList<>();
		
		for (Post post : posts) {
			dto.add(convert(post));
		}
		
		return dto;
	}

	
}
