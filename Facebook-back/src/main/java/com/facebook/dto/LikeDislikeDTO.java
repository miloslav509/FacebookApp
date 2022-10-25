package com.facebook.dto;

public class LikeDislikeDTO {

	private Long id;
	
	private UserDTO userDTO;
	
	private PostDTO postDTO;
	
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public PostDTO getPostDTO() {
		return postDTO;
	}

	public void setPostDTO(PostDTO postDTO) {
		this.postDTO = postDTO;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
