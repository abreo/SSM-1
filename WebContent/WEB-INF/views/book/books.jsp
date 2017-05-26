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
      <caption>所有图书列表.</caption>
      <thead>
        <tr>
        	<th></th>
        	<th></th>
        	<th>书名</th>
        	<th>版本</th>
        	<th>作者</th>
        	<th>出版社</th>
        	<th>价格</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${pageList.objs }" var="book" varStatus="status">
      		<tr>
      			<td scope="row">${ status.index + 1}</td>
      			<td>
      				<img src="${book.image }" alt="img" class="blog_img">
      			</td>
      			<td>
      				<a href="#" class="">《${book.name}》</a>
      			</td>
      			<td>
      				${book.version}
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
    
	<nav aria-label="Page navigation" style="margin-left: 300px">
		<ul class="pagination">
			
			<li>
				<c:if test="${pageList.pageNum == 1}">
					<a href="#" aria-label="Previous"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
				<c:if test="${pageList.pageNum > 1}">
					<a href="#" onclick="changeCenterGet('book/books/${pageList.pageNum - 1 }/5.action')" aria-label="Previous"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>

			<c:if test="${pageList.pageNum == 1 }">
				<li><a href="#" class="active">1</a></li>
			</c:if>
			<c:if test="${pageList.pageNum > 1 }">
				<li><a href="#"
					onclick="changeCenterGet('book/books/${pageList.pageNum - 1 }/5.action')">${pageList.pageNum - 1 }</a></li>
				<li><a href="#">${pageList.pageNum }</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum >= 3  }">
				<li><a href="#"
					onclick="changeCenterGet('book/books/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('book/books/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('book/books/${pageList.pageNum + 3 }/5.action')">${pageList.pageNum + 3}</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum < 3  }">
				<c:if test="${pageList.maxPage - pageList.pageNum == 2 }">
					<li><a href="#"
						onclick="changeCenterGet('book/books/${pageList.pageNum + 1 }/5.action)'">${pageList.pageNum + 1}</a></li>
					<li><a href="#"
						onclick="changeCenterGet('book/books/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				</c:if>
				<c:if test="${pageList.maxPage - pageList.pageNum == 1 }">
					<li><a href="#"
						onclick="changeCenterGet('book/books/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				</c:if>
			</c:if>

			<li>
				<c:if test="${pageList.pageNum == pageList.maxPage}">
					<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
				<c:if test="${pageList.pageNum < pageList.maxPage}">
					<a href="#" onclick="changeCenterGet('book/books/${pageList.pageNum + 1 }/5.action')" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>
		</ul>
		</nav>

</div>

</body>
</html>