package com.apache.team.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.apache.team.dto.CommentDTO;
import com.apache.team.model.Comment;

@Component
public class CommentToCommentDto implements Converter<Comment, CommentDTO> {

	@Override
	public CommentDTO convert(Comment s) {
		CommentDTO dto = new CommentDTO();
		
		dto.setId(s.getId());
		dto.setDateTime(s.getDateTime());
		dto.setDescription(s.getDescription());
		dto.setPostId(s.getPost().getId());
		dto.setUsername(s.getUser().getUsername());
		
		return dto;
	}
	
	public List<CommentDTO> convert(List<Comment> comments) {
		List<CommentDTO> dto = new ArrayList<>();
		
		for (Comment comment : comments) {
			dto.add(convert(comment));
		}
		
		return dto;
	}

	
}
