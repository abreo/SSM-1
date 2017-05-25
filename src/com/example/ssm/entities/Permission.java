package com.example.ssm.entities;

public class Permission {

	private Integer id;
	
	private String name;
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Permission() {
		super();
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", name=" + name + "]";
	}
	
	
}
