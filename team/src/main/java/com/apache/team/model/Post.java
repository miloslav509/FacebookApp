package com.apache.team.model;



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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




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
	
	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LikeDislike> likesDislikes = new ArrayList<>();
	
	@Column
	private int views;

	public Post() {
	}

	public Post(String description, String picturePath, String videoPath, String dateTime, User user) {
		super();
		this.description = description;
		this.picturePath = picturePath;
		this.videoPath = videoPath;
		this.dateTime = dateTime;
		this.user = user;
	}



	public Post(String description, String picturePath, String videoPath, String dateTime, User user,
			List<LikeDislike> likesDislikes, int views) {
		super();
		this.description = description;
		this.picturePath = picturePath;
		this.videoPath = videoPath;
		this.dateTime = dateTime;
		this.user = user;
		this.likesDislikes = likesDislikes;
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<LikeDislike> getLikesDislikes() {
		return likesDislikes;
	}

	public void setLikesDislikes(List<LikeDislike> likesDislikes) {
		this.likesDislikes = likesDislikes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, description, id, likesDislikes, picturePath, user, videoPath, views);
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
				&& Objects.equals(id, other.id) && Objects.equals(likesDislikes, other.likesDislikes)
				&& Objects.equals(picturePath, other.picturePath) && Objects.equals(user, other.user)
				&& Objects.equals(videoPath, other.videoPath) && views == other.views;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + ", picturePath=" + picturePath + ", videoPath="
				+ videoPath + ", dateTime=" + dateTime + ", user=" + user + ", likesDislikes=" + likesDislikes
				+ ", views=" + views + "]";
	}

	

	

	
	

}
