package com.example.ssm.entities;

import java.io.Serializable;

public class Nationality implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String name;

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

	public Nationality(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Nationality(String name) {
		super();
		this.name = name;
	}
	
	public Nationality(Integer id) {
		super();
		this.id = id;
	}

	public Nationality() {
		super();
	}

	@Override
	public String toString() {
		return "Nationality [id=" + id + ", name=" + name + "]";
	}
	
}
