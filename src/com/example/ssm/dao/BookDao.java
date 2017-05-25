package com.example.ssm.dao;

import java.util.List;

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
	
	public List<Book> getAllMyBooks(Integer id) {
		return bookMapper.getAllMyBooks(id);
	} 
}
