package com.example.ssm.entities;

public class Tag {

	private Integer id;
	
	private String name;
	
	private Tag parentTag;

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

	public Tag getParentTag() {
		return parentTag;
	}

	public void setParentTag(Tag parentTag) {
		this.parentTag = parentTag;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", parentTag=" + parentTag + "]";
	}

	public Tag() {
		super();
	}

	public Tag(String name) {
		super();
		this.name = name;
	}
	
	
	
}
