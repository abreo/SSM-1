package com.example.ssm.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Blog  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private User writer;
	
	private Set<Tag> tags;
	
	private String url;
	
	private long PV;
	
	private Set<Message> msgs;
	
	private Date createTime;
	
	private String title;
	
	private String content;
	
	private String type;
	
	private Type contentType;
	
	enum TYPE {
		REPRINTED ,//转载
		ORIGINAL //原创
	}

	public Type getContentType() {
		return contentType;
	}

	public void setContentType(Type contentType) {
		this.contentType = contentType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getPV() {
		return PV;
	}

	public void setPV(long pV) {
		PV = pV;
	}

	public Set<Message> getMsgs() {
		return msgs;
	}

	public void setMsgs(Set<Message> msgs) {
		this.msgs = msgs;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Blog() {
		super();
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", writer=" + writer + ", tags=" + tags + ", url=" + url + ", PV=" + PV + ", msgs="
				+ msgs + ", createTime=" + createTime + ", title=" + title + ", content=" + content + ", type=" + type
				+ "]";
	}
	
	
}
