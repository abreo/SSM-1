<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
label .blog_img {
    display: inline-block;
    vertical-align: middle;
    width: 40px;
    height: 40px;
    border-radius: 50%;
    border: solid 1px #dae4ea;
    margin-right: 10px;
}
.book_span {
margin-left:50px
}
</style>
</head>
<body>
<h3>我的图书</h3>
<div class="bs-example bs-example-type table-responsive" data-example-id="simple-headings">
    <table class="table">
      <caption>所有用戶列表.</caption>
      <thead>
        <tr>
        	<th></th>
        	<th></th>
        	<th>書名</th>
        	<th>作者</th>
        	<th>出版社</th>
        	<th>價格</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${books }" var="book" varStatus="status">
      		<tr>
      			<td scope="row">${ status.index + 1}</td>
      			<td>
      				<img src="${book.image }" alt="img" class="blog_img">
      			</td>
      			<td>
      				<a href="#" class="">《${book.name}》</a>
      			</td>
      			<td>
      				<b class="blog_b_margin">${book.author.name}</b>
      			</td>
      			<td>${book.press.name }</td>
      			<td>￥${book.price }</td>
      		</tr>
      	</c:forEach>
      </tbody>
    </table>
    <nav aria-label="Page navigation"  style="margin-left: 300px">
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>

</body>
</html>