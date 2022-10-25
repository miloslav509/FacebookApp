package com.facebook.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class LikeDislike {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Enumerated(EnumType.STRING)
	private LikeType type;
	
	@ManyToOne
	private Post post;
	
	@ManyToOne 
	private User user;

	public LikeDislike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikeDislike(LikeType type, Post post, User user) {
		super();
		this.type = type;
		this.post = post;
		this.user = user;
	}

	public LikeDislike(Long id, LikeType type, Post post, User user) {
		super();
		this.id = id;
		this.type = type;
		this.post = post;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LikeType getType() {
		return type;
	}

	public void setType(LikeType type) {
		this.type = type;
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
		return Objects.hash(id, post, type, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LikeDislike other = (LikeDislike) obj;
		return Objects.equals(id, other.id) && Objects.equals(post, other.post) && type == other.type
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "LikeDislike [id=" + id + ", type=" + type + ", post=" + post + ", user=" + user + "]";
	}
	
	

}
