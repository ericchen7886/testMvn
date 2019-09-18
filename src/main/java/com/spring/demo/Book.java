package com.spring.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//標記微ORM可注入對象
//@Entity聲明為ORM體系,納入Spring JPA使用

@Entity
public class Book {

	@Id //對應資料庫的component
	@GeneratedValue(strategy=GenerationType.AUTO) //選擇生成方式 : 自動生成
	private long id;
	
	private String name;
	
	private String author;
	
	private int status;

	private String description;

	public Book() {
		
	}

	
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
}
