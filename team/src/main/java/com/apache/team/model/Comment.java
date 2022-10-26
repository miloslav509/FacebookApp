package com.apache.team.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String description;
	
	@Column
	private String dateTime;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne 
	private User user;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String description, String dateTime, Post post, User user) {
		super();
		this.description = description;
		this.dateTime = dateTime;
		this.post = post;
		this.user = user;
	}

	public Comment(Long id, String description, String dateTime, Post post, User user) {
		super();
		this.id = id;
		this.description = description;
		this.dateTime = dateTime;
		this.post = post;
		this.user = user;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateTime, description, id, post, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(post, other.post) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", dateTime=" + dateTime + ", post=" + post
				+ ", user=" + user + "]";
	}
	
	
}
