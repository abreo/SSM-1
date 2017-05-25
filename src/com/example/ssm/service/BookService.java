package com.example.ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.BookDao;
import com.example.ssm.entities.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}
	
	public List<Book> getAllMyBooks(Integer id) {
		return bookDao.getAllMyBooks(id);
	}
	
}

