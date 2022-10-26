package com.apache.team.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.apache.team.dto.PostDTO;
import com.apache.team.model.Post;


@Component
public class PostToPostDto implements Converter<Post, PostDTO> {

	@Autowired
	private LikeDislikeToLikeDislikeDto toLikeDislikeDto;
	
	@Override
	public PostDTO convert(Post s) {
		PostDTO dto = new PostDTO();
		
		dto.setId(s.getId());
		dto.setDateTime(s.getDateTime());
		dto.setDescription(s.getDescription());
		dto.setLikesDislikes(toLikeDislikeDto.convert(s.getLikesDislikes()));
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
