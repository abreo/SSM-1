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
<br/><br/><br/>
<input type="text" id="searchBook"/>
<input type="text" id="bookId" type="hidden" />
<br/>
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
					<a href="#" onclick="changeCenterGet('admin/books/${pageList.pageNum - 1 }/5.action')" aria-label="Previous"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>

			<c:if test="${pageList.pageNum == 1 }">
				<li><a href="#" class="active">1</a></li>
			</c:if>
			<c:if test="${pageList.pageNum > 1 }">
				<li><a href="#"
					onclick="changeCenterGet('admin/books/${pageList.pageNum - 1 }/5.action')">${pageList.pageNum - 1 }</a></li>
				<li><a href="#">${pageList.pageNum }</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum >= 3  }">
				<li><a href="#"
					onclick="changeCenterGet('admin/books/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('admin/books/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				<li><a href="#"
					onclick="changeCenterGet('admin/books/${pageList.pageNum + 3 }/5.action')">${pageList.pageNum + 3}</a></li>
			</c:if>
			<c:if test="${pageList.maxPage - pageList.pageNum < 3  }">
				<c:if test="${pageList.maxPage - pageList.pageNum == 2 }">
					<li><a href="#"
						onclick="changeCenterGet('admin/books/${pageList.pageNum + 1 }/5.action)'">${pageList.pageNum + 1}</a></li>
					<li><a href="#"
						onclick="changeCenterGet('admin/books/${pageList.pageNum + 2 }/5.action')">${pageList.pageNum + 2}</a></li>
				</c:if>
				<c:if test="${pageList.maxPage - pageList.pageNum == 1 }">
					<li><a href="#"
						onclick="changeCenterGet('admin/books/${pageList.pageNum + 1 }/5.action')">${pageList.pageNum + 1}</a></li>
				</c:if>
			</c:if>

			<li>
				<c:if test="${pageList.pageNum == pageList.maxPage}">
					<a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
				<c:if test="${pageList.pageNum < pageList.maxPage}">
					<a href="#" onclick="changeCenterGet('admin/books/${pageList.pageNum + 1 }/5.action')" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a>
				</c:if>
			</li>
		</ul>
		</nav>

</div>

</body>
<script type="text/javascript" src="jqueryui/jquery-ui.min.js"></script>
<script type="text/javascript">
$("#searchBook").autocomplete({
    source: function(request, response) {
		url = "/new_kpi/kpi/user/user/" + request.term;
		args = {
			"time" : new Date()
		};
		$.ajax({
			url : "/new_kpi/kpi/user/user/" + request.term,
			dataType : "json",
			type : 'GET',
			data : {
				"time" : new Date()
			},
			success : function(data) {
				response($.map(data.message, function(item) {
					return {
						id : item.id,
						label : item.chineseName,
						name : item.username,
						email : item.email,
						tel : item.tel
					};
				}));
			}
		});
	},
	select: function(event, ui){
	    // 这里的this指向当前输入框的DOM元素
	    // event参数是事件对象
	    // ui对象只有一个item属性，对应数据源中被选中的对象
	    $(this).value = ui.item.label;
	    $("#bookId").val( ui.item.id );
	    alert(ui.item.sayhello);
	    // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
	    event.preventDefault();     
	}
});
</script>
</html>