package com.example.ssm.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.example.ssm.entities.Book;

public interface BookMapper {
	
	Book getBookById(Integer id);
	
	int getBookCount(@Param("id") Integer id);
	
	List<Book> getAllBooks(Map<String,Object> map);
	
	List<Map<String,Object>> getBooksByPointMsg(@Param("msg") String msg);
	
	void addBook(Book book);
}
