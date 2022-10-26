package com.apache.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apache.team.dto.CommentDTO;
import com.apache.team.dto.LikeDislikeDTO;
import com.apache.team.model.Comment;
import com.apache.team.model.LikeDislike;
import com.apache.team.service.CommentService;
import com.apache.team.service.impl.CommentServiceImpl;
import com.apache.team.support.CommentDtoToComment;
import com.apache.team.support.CommentToCommentDto;
@RestController
@RequestMapping(value = "/api/comments")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	@Autowired
	private CommentServiceImpl service;
	
	@Autowired
	private CommentToCommentDto toCommentDto;
	
	@Autowired
	private CommentDtoToComment toComment;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO) {
		
		Comment comment = toComment.convert(commentDTO);
		
		if (comment.getPost() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Comment saveComment = service.create(comment);
		
		return new ResponseEntity<>(toCommentDto.convert(saveComment), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		Comment comment = service.getOne(id);
		
		if (comment == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
