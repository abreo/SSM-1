package com.example.ssm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Author implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private Nationality nation;
	
	private Date birth;
	
	private List<Book> books;
	
	private String msg;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Nationality getNation() {
		return nation;
	}

	public void setNation(Nationality nation) {
		this.nation = nation;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Author(Integer id, String name, Nationality nation, Date birth, List<Book> books, String msg) {
		super();
		this.id = id;
		this.name = name;
		this.nation = nation;
		this.birth = birth;
		this.books = books;
		this.msg = msg;
	}

	public Author(String name, Nationality nation, Date birth, List<Book> books, String msg) {
		super();
		this.name = name;
		this.nation = nation;
		this.birth = birth;
		this.books = books;
		this.msg = msg;
	}

	public Author(Integer id) {
		this.id = id;
	} 
	
	public Author() {
		super();
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", nation=" + nation + ", birth=" + birth + ", books=" + books
				+ ", msg=" + msg + "]";
	}
	
}
