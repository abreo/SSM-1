package com.example.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ssm.entities.Book;
import com.example.ssm.inter.BookMapper;

@Repository
public class BookDao {

	@Autowired
	private BookMapper bookMapper;
	
	public Book getBookById(Integer id) {
		return bookMapper.getBookById(id);
	}
	
	public List<Book> getAllbooks(Map<String,Object> map) {
		return bookMapper.getAllBooks(map);
	} 
	
	public List<Book> getAllBooks(Map<String,Object> map) {
		return bookMapper.getAllBooks(map);
	}
	
	public int getBookCount(Integer id) {
		return bookMapper.getBookCount(id);
	}
	
	public List<Map<String,Object>> getBooksByPointMsg(String msg) {
		return bookMapper.getBooksByPointMsg(msg);
	}
	
	public void addBook(Book book) {
		bookMapper.addBook(book);
	}
}
