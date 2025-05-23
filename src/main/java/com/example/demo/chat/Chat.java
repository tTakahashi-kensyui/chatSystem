package com.example.demo.chat;

import jakarta.validation.constraints.NotBlank;

public class Chat {

	@NotBlank(message = "名前を入力してください")
	private String Name;
	
	@NotBlank(message = "文字を入力してください")
	private String Comment;

	public Chat() {
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	
	
}
