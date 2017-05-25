package com.example.ssm.inter;

import java.util.List;

import com.example.ssm.entities.Book;

public interface BookMapper {

	Book getBookById(Integer id);
	
	List<Book> getAllMyBooks(Integer id);
	
}
