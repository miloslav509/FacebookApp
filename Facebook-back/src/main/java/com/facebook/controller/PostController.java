package com.facebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facebook.dto.PostDTO;
import com.facebook.model.Post;
import com.facebook.service.PostService;
import com.facebook.support.PostDtoToPost;
import com.facebook.support.PostToPostDto;

@RestController
@RequestMapping(value = "/api/posts")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

	@Autowired
	private PostService service;
	
	@Autowired
	private PostToPostDto toPostDto;
	
	@Autowired
	private PostDtoToPost toPost;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PostDTO>> getAllSearch(
			@RequestParam(defaultValue = "0") int pageNo) {
		Page<Post> posts = service.findAll(pageNo);
		
		List<PostDTO> postsDto = toPostDto.convert(posts.toList());
		
		Page<PostDTO> postsPage = new PageImpl<>(postsDto, posts.getPageable(), posts.getTotalElements());
		
		return new ResponseEntity<>(postsPage, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PostDTO> getOne(@PathVariable Long id) {
		Post post = service.findOne(id);
		
		if (post != null) {
			return new ResponseEntity<>(toPostDto.convert(post), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Post post = service.findOne(id);
		
		if (post != null) {
			service.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping
	public ResponseEntity<PostDTO> create(@RequestBody PostDTO postDTO) {
		Post post = toPost.convert(postDTO);
		Post retVal = service.save(post);
		
		if (retVal != null) {
			return new ResponseEntity<>(toPostDto.convert(retVal), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
