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
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LikeDislike> likesDislikes = new ArrayList<>();

	public User() {
		super();
	}

	public User(Long id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<LikeDislike> getLikesDislikes() {
		return likesDislikes;
	}

	public void setLikesDislikes(List<LikeDislike> likesDislikes) {
		this.likesDislikes = likesDislikes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, likesDislikes, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(likesDislikes, other.likesDislikes)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", likesDislikes="
				+ likesDislikes + "]";
	}

	
	
	
	
	
	
}
