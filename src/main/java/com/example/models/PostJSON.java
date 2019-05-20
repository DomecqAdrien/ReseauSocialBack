package com.example.models;

import java.awt.TextArea;
import java.sql.Date;

public class PostJSON {

	private int id;
	private String titre;
	private Date date;
	private TextArea contenu;
	private int id_user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TextArea getContenu() {
		return contenu;
	}
	public void setContenu(TextArea contenu) {
		this.contenu = contenu;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
}