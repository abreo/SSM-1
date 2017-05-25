package com.example.ssm.entities;

import java.util.List;
import java.util.Set;

public class User {

	private Integer id;
	
	private String name;
	
	private List<Book> books;
	
	private Set<Role> roles;
	
	private String username;
	
	private String password;
	
	private String email;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public User() {
		super();
	}

	public User(Integer id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", books=" + books + "]";
	}
	
	
	
}
