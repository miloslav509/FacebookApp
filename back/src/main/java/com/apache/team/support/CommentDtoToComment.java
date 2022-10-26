package com.apache.team.support;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.apache.team.dto.CommentDTO;
import com.apache.team.model.Comment;
import com.apache.team.service.CommentService;
import com.apache.team.service.PostService;
import com.apache.team.service.UserService;

@Component
public class CommentDtoToComment implements Converter<CommentDTO, Comment> {

	@Autowired
	private CommentService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;

	@Override
	public Comment convert(CommentDTO dto) {
		Comment comment;
		
		if (dto.getId() != null) {
			comment = service.getOne(dto.getId());
		} else {
			comment = new Comment();
		}
		
		if (comment != null) {
			comment.setDateTime(LocalDateTime.now().toString());
			comment.setDescription(dto.getDescription());
			comment.setPost(postService.findOne(dto.getPostId()));
			comment.setUser(userService.findById(dto.getUserId()));
		}
		
		return comment;
	}
	
	
}
