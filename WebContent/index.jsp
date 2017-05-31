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
<link href="bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">
/* Move down content because we have a fixed navbar that is 3.5rem tall */
body {
	padding-top: 3.5rem;
}

h1 {
	margin-bottom: 20px;
	padding-bottom: 9px;
	border-bottom: 1px solid #eee;
}

.sidebar {
	position: fixed;
	top: 51px;
	bottom: 0;
	left: 0;
	z-index: 1000;
	padding: 20px;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
	border-right: 1px solid #eee;
}

.sidebar {
	padding-left: 0;
	padding-right: 0;
}

.sidebar .nav {
	margin-bottom: 20px;
}

.sidebar .nav-item {
	width: 100%;
}

.sidebar .nav-item+.nav-item {
	margin-left: 0;
}

.sidebar .nav-link {
	border-radius: 0;
}

.placeholders {
	padding-bottom: 3rem;
}

.placeholder img {
	padding-top: 1.5rem;
	padding-bottom: 1.5rem;
}

.redback {
	background: #CC0000
}

.navtext {
	font-size: 22px
}

.myself_main {
	margin-top: 5px;
	margin-left: 17.7%;
}

.list_li {
	margin-top: 20px
}

.record_text {
	font-weight: normal;
	color: #333;
	vertical-align: middle;
}

.emm_text {
	opacity: 0.5;
	filter: alpha(opacity = 50);
	display: inline-block;
	border-radius: 50%;
	background: #b8b8b8;
	width: 25px;
	height: 25px;
	font-size: 16px;
	color: black;
	text-align: center;
	line-height: 25px;
	margin-right: 5px;
	vertical-align: middle;
}
</style>
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
			<nav class="col-sm-3 col-md-2 d-none d-sm-block bg-faded sidebar">
				<!--  col-md-2 d-none d-sm-block bg-faded sidebar -->
				<ul class="nav nav-pills flex-column">
					<li class="nav-item"><a class="nav-link active" href="#"
						onclick="changeCenterGet('book/books/1/5.action')">我的图书</a></li>
					<li class="nav-item"><a class="nav-link" href="#">博客</a></li>
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

			<main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3 myself_main"
				role="main">
				<div class="rankList clearfix" id="center">
				
				</div>
			</main>
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
</html>

