package com.facebook.dto;

import java.util.List;

public class PostDTO {

	private Long id;
	
	private String description;
	
	private String picturePath;
	
	private String videoPath;
	
	private String dateTime;
	
	private String username;
	
	private List<LikeDislikeDTO> likesDislikes;
	
	private int views;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<LikeDislikeDTO> getLikesDislikes() {
		return likesDislikes;
	}

	public void setLikesDislikes(List<LikeDislikeDTO> likesDislikes) {
		this.likesDislikes = likesDislikes;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
	
}
