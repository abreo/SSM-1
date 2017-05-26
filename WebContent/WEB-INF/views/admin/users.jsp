<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户管理</h3>
	<div class="bs-example bs-example-type table-responsive"
		data-example-id="simple-headings">
		<table class="table">
			<caption>所有用戶列表.</caption>
			<thead>
				<tr>
					<th>編號</th>
					<th>姓名</th>
					<th>賬號</th>
					<th>密碼</th>
					<th>郵箱</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageList.objs }" var="user" varStatus="status">
					<tr>
						<th scope="row">${ status.index + 1}</th>
						<td>${user.name}</td>
						<td>${user.username }</td>
						<td>${user.password }</td>
						<td>${user.email}</td>
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
					<a href="#" onclick="changeCenterGet('admin/users/${pageList.pageNum - 1 }/5.action')" aria-label="Previous"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>

			<c:if test="${pageList.pageNum == 1 }">
				<li><a href="#" class="active">1</a></li>
			</c:if>
			<c:if test="${pageList.pageNum > 1 }">
				<li><a href="#"
					onclick="changeCenterGet('admin/users/${pageList.pageNum - 1 }/5.action')">${pageList.pageNum - 1 }</a></li>
				<li><a href="#">${pageList.pageNum }</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum >= 3  }">
				<li><a href="#"
					onclick="changeCenterGet('admin/users/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('admin/users/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('admin/users/${pageList.pageNum + 3 }/5.action')">${pageList.pageNum + 3}</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum < 3  }">
				<c:if test="${pageList.maxPage - pageList.pageNum == 2 }">
					<li><a href="#"
						onclick="changeCenterGet('admin/users/${pageList.pageNum + 1 }/5.action)'">${pageList.pageNum + 1}</a></li>
					<li><a href="#"
						onclick="changeCenterGet('admin/users/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				</c:if>
				<c:if test="${pageList.maxPage - pageList.pageNum == 1 }">
					<li><a href="#"
						onclick="changeCenterGet('admin/users/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				</c:if>
			</c:if>

			<li>
				<c:if test="${pageList.pageNum == pageList.maxPage}">
					<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
				<c:if test="${pageList.pageNum < pageList.maxPage}">
					<a href="#" onclick="changeCenterGet('admin/users/${pageList.pageNum + 1 }/5.action')" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>
		</ul>
		</nav>
	</div>
</body>
</html>
