package com.facebook.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.facebook.dto.LikeDislikeDTO;
import com.facebook.model.LikeDislike;

@Component
public class LikeDislikeToLikeDislikeDto implements Converter<LikeDislike, LikeDislikeDTO> {

	@Autowired
	private PostToPostDto toPostDto;
	
	@Autowired
	private USerToUSerDto toUSerDto;
	
	@Override
	public LikeDislikeDTO convert(LikeDislike s) {
		LikeDislikeDTO dto = new LikeDislikeDTO();
		
		dto.setId(s.getId());
		dto.setPostDTO(toPostDto.convert(s.getPost()));
		dto.setUserDTO(toUSerDto.convert(s.getUser()));
		dto.setType(s.getType().toString());
		
		return dto;
	}
	
	public List<LikeDislikeDTO> convert(List<LikeDislike> likeDislikes) {
		List<LikeDislikeDTO> dto = new ArrayList<>();
		
		for (LikeDislike likeDislike : likeDislikes) {
			dto.add(convert(likeDislike));
		}
		
		return dto;
	}
}
