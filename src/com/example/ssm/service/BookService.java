package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ssm.dao.BookDao;
import com.example.ssm.entities.Book;
import com.example.ssm.util.PageList;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}
	
	/**
	 * 获取所有书（若传入人员Id，则搜索该用户的全部书）
	 * @param id
	 * @param pageNum
	 * @param rowCount
	 * @return
	 */
	public PageList<Book> getAllBooks(Integer id ,int pageNum,int rowCount) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pageNum", (pageNum-1)*rowCount);
		map.put("rowCount", rowCount);
		List<Book> books = bookDao.getAllBooks(map);
		PageList<Book> pageList = new PageList<>();
		pageList.setMaxCount(bookDao.getBookCount(id));
		pageList.setPageNum(pageNum);
		pageList.setObjs(books);
		return pageList;
	}
	
	/**
	 * 关键字搜索
	 * @param msg
	 * @param pageNum
	 * @param rowCount
	 * @return
	 */
	public Map<String,Object> getBookByPointMsg(@PathVariable("msg") String msg) {
		List<Map<String,Object>> maps = bookDao.getBooksByPointMsg("%"+msg+"%");
		Map<String,Object> map = new HashMap<>();
		map.put("message", maps);
		return map;
	}
	
	public String findBookById(Integer id) {
		Book book = bookDao.getBookById(id);
		StringBuilder sb = new StringBuilder();
		sb.append("<table class='table'>");
		sb.append("<caption>所有图书列表.</caption>");
	    sb.append("<thead> <tr> <th></th> <th></th>");
	    sb.append("<th>书名</th> <th>版本</th> <th>作者</th> <th>出版社</th> <th>价格</th>") ;
	    sb.append("</tr> </thead> <tbody> <tr>");
	    sb.append("<td scope='row'>1</td>");
	    sb.append("<td><img src="+book.getImage()+" alt='img' class='blog_img'></td>");
	    sb.append("<td><a href='#' class=''>《"+book.getName()+"》</a></td>");
	    sb.append("<td>"+book.getVersion()+"</td>");
	    sb.append("<td><b class='blog_b_margin'>"+book.getAuthor().getName()+"</b></td>");
	    sb.append("<td>"+book.getPress().getName()+"</td>");
	    sb.append("<td>￥"+book.getPrice()+"</td>");
	    sb.append("</tr>");
	    sb.append("</tbody> </table>");
	    sb.append("<nav aria-label='Page navigation'  style='margin-left: 450px'>");  
	    sb.append("<ul class='pagination'>");
	    sb.append("<li>");
	    sb.append("<a href='#' aria-label='Previous'> <span aria-hidden='true'>&raquo;</span></a>");
	    sb.append("</li>");
	    sb.append("<li><a href='#' class='active'>1</a></li>");  			
	    sb.append("<li><a href='#' aria-label='Next'> <span aria-hidden='true'>&raquo;</span></a></li>");
	    sb.append("</ul></nav>");
	    return sb.toString();
	}
	
	public void addBook(Book book) {
		bookDao.addBook(book);
	}
}

