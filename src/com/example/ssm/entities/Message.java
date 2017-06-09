package com.example.ssm.entities;

import java.util.Date;

public class Message {

	private Integer id;
	
	private String msg;
	
	private User writer;
	
	private Date writeTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Date getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", msg=" + msg + ", writer=" + writer + ", writeTime=" + writeTime + "]";
	}

	public Message() {
		super();
	}
	
	
	
}
