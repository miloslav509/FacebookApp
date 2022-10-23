package com.facebook.dto;

import java.util.List;

public class PostDTO {

	private Long id;
	
	private String description;
	
	private String picturePath;
	
	private String videoPath;
	
	private String dateTime;
	
	private String username;
	
	private List<UserDTO> likes;
	
	private List<UserDTO> dislikes;
	
	private int likesNumber;
	
	private int dislikesNumber;
	
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

	public List<UserDTO> getLikes() {
		return likes;
	}

	public void setLikes(List<UserDTO> likes) {
		this.likes = likes;
	}

	public List<UserDTO> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<UserDTO> dislikes) {
		this.dislikes = dislikes;
	}

	public int getLikesNumber() {
		return likesNumber;
	}

	public void setLikesNumber(int likesNumber) {
		this.likesNumber = likesNumber;
	}

	public int getDislikesNumber() {
		return dislikesNumber;
	}

	public void setDislikesNumber(int dislikesNumber) {
		this.dislikesNumber = dislikesNumber;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
	
	
}
