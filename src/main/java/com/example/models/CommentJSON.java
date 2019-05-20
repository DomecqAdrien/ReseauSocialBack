package com.example.models;

import java.sql.Date;

public class CommentJSON {

	private long id;
	private Date date;
	private String commentaire;
	private long id_user;
	private long id_post;
	private Post post;
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public long getId_post() {
		return id_post;
	}
	public void setId_post(long id_post) {
		this.id_post = id_post;
	}
	
}
