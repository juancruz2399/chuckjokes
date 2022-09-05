package com.example.demo.app.Entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "jokes")
public class Jokes implements Serializable{

	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jokes")
    private Long id_Jokes;
	
	@Column(name = "date_save")
	private Date Date_save;
	
	@Column(name = "joke")
	private String Joke;

	@JoinColumn(name ="id_usuario_fk",referencedColumnName ="id_usuario")
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private User user;
	
	/********************* GET Y SET *****************************/
	
	public static long getSerialVersionUID(){
		return serialVersionUID;
	}
	
	public Long getId_Jokes() {
		return id_Jokes;
	}

	public void setId_Jokes(Long id_Jokes) {
		this.id_Jokes = id_Jokes;
	}

	public Date getDate_save() {
		return Date_save;
	}

	public void setDate_save(Date date_save) {
		Date_save = date_save;
	}

	public String getJoke() {
		return Joke;
	}

	public void setJoke(String joke) {
		Joke = joke;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
