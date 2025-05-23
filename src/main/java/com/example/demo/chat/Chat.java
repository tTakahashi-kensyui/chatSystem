package com.example.demo.chat;

public class Chat {

	//@NotBlank(message = "名前を入力してください")
	private String Name;
	

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
