package com.example.ssm.entities;


import java.io.Serializable;
import java.util.Date;

public class Book  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String name;
	
	private float price;
	
	private String isbn;
	
	private Press press;
	
	private int version;
	
	private Date publishDate;
	
	private Date printDate;
	
	private String msg;
	
	private String image;
	
	private Author author;
	

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Press getPress() {
		return press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Book(Integer id, String name, float price, String isbn, Press press, int version, Date publishDate,
			Date printDate, String msg, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.isbn = isbn;
		this.press = press;
		this.version = version;
		this.publishDate = publishDate;
		this.printDate = printDate;
		this.msg = msg;
		this.image = image;
	}

	public Book(String name, float price, String isbn, Press press, int version, Date publishDate, Date printDate,
			String msg, String image) {
		super();
		this.name = name;
		this.price = price;
		this.isbn = isbn;
		this.press = press;
		this.version = version;
		this.publishDate = publishDate;
		this.printDate = printDate;
		this.msg = msg;
		this.image = image;
	}

	public Book(Integer id) {
		super();
		this.id = id;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", isbn=" + isbn + ", press=" + press				+ ", version=" + version + ", publishDate=" + publishDate + ", printDate=" + printDate + ", msg=" + msg
				+ ", image=" + image + ", author=" + author + "]";
	}

	
	
}
