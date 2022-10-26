package com.apache.team.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.apache.team.dto.LikeDislikeDTO;
import com.apache.team.model.LikeDislike;
import com.apache.team.model.LikeType;
import com.apache.team.service.impl.LikeDislikeServiceImpl;
import com.apache.team.service.impl.PostServiceImpl;
import com.apache.team.service.impl.UserServiceImpl;



@Component
public class LikeDislikeDtoToLikeDislike implements Converter<LikeDislikeDTO, LikeDislike> {

	@Autowired
	private LikeDislikeServiceImpl service;
	
	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private PostServiceImpl postService;
	
	@Override
	public LikeDislike convert(LikeDislikeDTO dto) {
		LikeDislike likeDislike;
		
		if (dto.getId() != null) {
			likeDislike = service.findOne(dto.getId());
		} else {
			likeDislike = new LikeDislike();
		}
		
		if (likeDislike != null) {
			
			likeDislike.setPost(postService.findOne(dto.getPostId()));
			likeDislike.setUser(userService.findById(dto.getUserDTO().getId()));
			if (dto.getType().equals("like")) {
				likeDislike.setType(LikeType.LIKE);
			} else {
				likeDislike.setType(LikeType.DISLIKE);
			}
			
		}
		
		return likeDislike;
	}
	
	public List<LikeDislike> convert(List<LikeDislikeDTO> dto) {
		List<LikeDislike> likeDislikes = new ArrayList<>();
		
		for (LikeDislikeDTO likeDislikeDTO : dto) {
			likeDislikes.add(convert(likeDislikeDTO));
		}
		
		return likeDislikes;
	}
}
