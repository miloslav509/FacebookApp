package com.facebook.model;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String description;

	@Column(name = "picture_path")
	private String picturePath;
	
	@Column(name = "video_path")
	private String videoPath;
	
	@Column
	private String dateTime;
	
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	
	@OneToMany(mappedBy = "likes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> likes = new ArrayList<>();
	
	@OneToMany(mappedBy = "dislikes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> dislikes = new ArrayList<>();
	
	@Column
	private int likesNumber;
	
	@Column
	private int dislikesNumber;
	
	@Column
	private int views;

	public Post() {
	}

	public Post(String description, String picturePath, String videoPath, String dateTime, User user, List<User> likes,
			List<User> dislikes, int likesNumber, int dislikesNumber, int views) {
		super();
		this.description = description;
		this.picturePath = picturePath;
		this.videoPath = videoPath;
		this.dateTime = dateTime;
		this.user = user;
		this.likes = likes;
		this.dislikes = dislikes;
		this.likesNumber = likesNumber;
		this.dislikesNumber = dislikesNumber;
		this.views = views;
	}

	public Post(Long id, String description, String picturePath, String videoPath, String dateTime, User user,
			List<User> likes, List<User> dislikes, int likesNumber, int dislikesNumber, int views) {
		super();
		this.id = id;
		this.description = description;
		this.picturePath = picturePath;
		this.videoPath = videoPath;
		this.dateTime = dateTime;
		this.user = user;
		this.likes = likes;
		this.dislikes = dislikes;
		this.likesNumber = likesNumber;
		this.dislikesNumber = dislikesNumber;
		this.views = views;
	}

	public Post(String description, String picturePath, String videoPath, String dateTime, User user, int likesNumber,
			int dislikesNumber, int views) {
		super();
		this.description = description;
		this.picturePath = picturePath;
		this.videoPath = videoPath;
		this.dateTime = dateTime;
		this.user = user;
		this.likesNumber = likesNumber;
		this.dislikesNumber = dislikesNumber;
		this.views = views;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void setLikes(List<User> likes) {
		this.likes = likes;
	}

	public List<User> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<User> dislikes) {
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

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, description, dislikes, dislikesNumber, id, likes, likesNumber, picturePath, user,
				videoPath, views);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(description, other.description)
				&& Objects.equals(dislikes, other.dislikes) && dislikesNumber == other.dislikesNumber
				&& Objects.equals(id, other.id) && Objects.equals(likes, other.likes)
				&& likesNumber == other.likesNumber && Objects.equals(picturePath, other.picturePath)
				&& Objects.equals(user, other.user) && Objects.equals(videoPath, other.videoPath)
				&& views == other.views;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", picturePath=" + picturePath + ", videoPath="
				+ videoPath + ", dateTime=" + dateTime + ", user=" + user + ", likes=" + likes + ", dislikes="
				+ dislikes + ", likesNumber=" + likesNumber + ", dislikesNumber=" + dislikesNumber + ", views=" + views
				+ "]";
	}

	

	
	

}
