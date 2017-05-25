package com.example.ssm.entities;

import java.io.Serializable;
import java.util.List;

public class Press implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private String msg;
	
	private List<Book> books;

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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Press(Integer id) {
		super();
		this.id = id;
	}

	public Press(Integer id, String name, String msg, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.msg = msg;
		this.books = books;
	}

	public Press(String name, String msg, List<Book> books) {
		super();
		this.name = name;
		this.msg = msg;
		this.books = books;
	}

	public Press() {
		super();
	}

	@Override
	public String toString() {
		return "Press [id=" + id + ", name=" + name + ", msg=" + msg + ", books=" + books + "]";
	}
	
}
