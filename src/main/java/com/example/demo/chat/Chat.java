package com.example.demo.chat;

import jakarta.validation.constraints.NotBlank;

public class Chat {

	@NotBlank(message = "名前を入力してください")
	private String name;
	
	@NotBlank(message = "コメントを入力してください")
	private String comment;

	public Chat() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	

}
