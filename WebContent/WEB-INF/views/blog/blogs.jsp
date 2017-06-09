<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style type="text/css"> 
.author_head_image {
    display: block;
    width: 60px;
    height: 60px;
    margin: 0 auto 5px;
    border-radius: 50%;
}
</style>
<nav class="navbar navbar-default" style="margin-right:4%" role="navigation">
    <div class="container-fluid">
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">排行榜</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">分类
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">感悟心得</a></li>
                    <li><a href="#">读书随笔</a></li>
                    <li><a href="#">摘抄</a></li>
                    <li class="divider"></li>
                    <li><a href="#">科研技术</a></li>
                    <li><a href="#">脑洞大开</a></li>
                    <li class="divider"></li>
                    <li><a href="#">篝火夜话</a></li>
                    <li><a href="#">故事会</a></li>
                </ul>
            </li>
            <li class="active"><a href="#">写博客</a></li>
            <li class="active"><a href="#">我的博客</a></li>
        </ul>
    </div>
    </div>
</nav>
<h3>博客</h3>
<div class="bs-example bs-example-type table-responsive" data-example-id="simple-headings">
    <table class="table">
      <caption>博客排行.</caption>
      <thead>
        <tr>
        	<th></th>
        	<th></th>
        	<th>标题</th>
        	<th>发表时间</th>
        	<th>访问量</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach items="${pageList.objs }" var="blog" varStatus="status">
      		<tr>
      			<td scope="row">${ status.index + 1}</td>
      			<td>
      				<img src="${blog.writer.headImageUrl }" alt="img" class="blog_img">
      			</td>
      			<td>
      				<a href="#" class="">《${blog.title}》</a>
      			</td>
      			<td>
      				${blog.createTime}
      			</td>
      			<td>
      				<b class="blog_b_margin">${blog.PV}</b>
      			</td>
      		</tr>
      	</c:forEach>
      </tbody>
    </table>
    
	<nav aria-label="Page navigation" style="margin-left: 450px">
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
				<c:if test="${0 == pageList.maxPage}">
					<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>
		</ul>
		</nav>
</div>
