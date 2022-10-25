package com.facebook.controller;



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

import com.facebook.dto.LikeDislikeDTO;
import com.facebook.model.LikeDislike;
import com.facebook.service.LikeDislikeService;
import com.facebook.support.LikeDislikeDtoToLikeDislike;
import com.facebook.support.LikeDislikeToLikeDislikeDto;

@RestController
@RequestMapping(value = "/api/likes")
@CrossOrigin(origins = "http://localhost:4200")
public class LikeDislikeController {

	@Autowired
	private LikeDislikeService likeDislikeService;
	
	@Autowired
	private LikeDislikeDtoToLikeDislike toLike;
	
	@Autowired
	private LikeDislikeToLikeDislikeDto toDto;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LikeDislikeDTO> create(@RequestBody LikeDislikeDTO komentarDTO) {
		
		LikeDislike like = toLike.convert(komentarDTO);
		
		if (like.getPost() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		LikeDislike sacuvanLike = likeDislikeService.save(like);
		
		return new ResponseEntity<>(toDto.convert(sacuvanLike), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		
		LikeDislike like = likeDislikeService.delete(id);
		
		if (like == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
