<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="Json">
<title>图书管理系统</title>
<link href="bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<ul class="nav navbar-nav navbar-right" style="margin-right:5%">
			
			<li>
				<c:if test="${empty loginUser }">
					<a href="#" onclick="changeCenterGet('user/login.html')" role="button" data-toggle="modal"> 
						<i class="icon-male-sign-alt icon-2x"></i>
						<p>登录/注册</p>
					</a>
				</c:if>
				<c:if test="${!empty loginUser }">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" 
							aria-haspopup="true" aria-expanded="false">${loginUser.name }
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="#">个人中心</a></li>
							<li><a href="#" onclick="changeCenterGet('user/logout.action')">注销用户</a></li>
						</ul>
					</li>
				</c:if>
			</li>
		</ul>
	</nav>

	<div class="container-fluid page_body">
		<div class="row">
			<nav class="col-md-2 col-sm-3 d-none d-sm-block bg-faded sidebar">
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#"
						onclick="changeCenterGet('book/books/1/5.action')">我的图书</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						onclick="changeCenterGet('blog/blogs/1/5.action')">博客</a></li>
					<li class="nav-item"><a class="nav-link" href="#">新闻</a></li>
					<li class="nav-item"><a class="nav-link" href="#">论坛</a></li>
				</ul>
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link" href="#"
						id="redis_try_online">在线阅读</a></li>
					<li class="nav-item"><a class="nav-link" href="#">读书笔记</a></li>
				</ul>
	
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link" href="#"
						onclick="changeCenterGet('admin/users/1/5.action')">用户管理</a></li>
					<li class="nav-item"><a class="nav-link" href="#"
						onclick="changeCenterGet('admin/books/1/5.action')">图书管理</a></li>
				</ul>
	
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link" href="#">下载</a></li>
				</ul>
			</nav>

			<div class=" col-md-10 col-sm-9 offset-md-2 offset-sm-3 myself_main">
				<div class="rankList clearfix" id="center">
				
				</div>
			</div>
		</div>
		<div class="row footer-bottom" style="margin-top: 200p; margin-left:120px">
			<ul class="list-inline text-center">
				<li><a href="http://www.miibeian.gov.cn/" target="_blank"></a></li>
				<li>阅读改变生活</li>
			</ul>
		</div>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/public/public.js"></script>
<script type="text/javascript">
/* 检测是否有待跳转的页面 */
var url = "public/page.html";
var args = {"time":new Date()}
$.get(url,args,function(data) {
	if(data != 1) {
		changeCenterGet(data);
	}
});
</script>
</html>

