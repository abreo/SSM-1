package com.example.ssm.entities;

public class Label {

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

	public Label(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Label(String name) {
		super();
		this.name = name;
	}

	public Label(Integer id) {
		super();
		this.id = id;
	}

	public Label() {
		super();
	}
	
	
	
}
