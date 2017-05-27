<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .addbook-column {
	padding-top:5px;
	padding-bottom:5px;
} 
.addbook-row {
}
.addbook-container {
	padding-bottom : 10px
}

.ui-helper-hidden-accessible {display:none;}  
.ui-autocomplete { position: absolute; cursor: default; border-radius: 3px; border: 1px solid #c0c0c0; }    
.ui-menu {list-style: none;padding: 0;margin: 0;display: block;outline: none;}  
.ui-menu .ui-menu-item a {text-decoration:none;display:block;padding:.2em .4em;line-height:1.5;zoom:1;}  
  
 .ui-state-hover, .ui-widget-content .ui-state-hover, .ui-widget-header .ui-state-hover, .ui-state-focus, .ui-widget-content .ui-state-focus, .ui-widget-header .ui-state-focus {background: #ff8a00;border: none;color:#eeee;border-radius:0;font-weight: normal;}  
</style>
</head>
<body>
<h3>添加图书</h3>

<div class="addbook_form" style="padding-right: 20px ; margin-right : 20px;background-color: #eee">
	<div class="container addbook-container" style="">
		<div class="row addbook-row">
			<div class="column addbook-column col-md-1">书名</div>
			<div class="column addbook-column col-md-3"><input type="text" name="bookName" id="bookName"/></div>
			<div class="column addbook-column col-md-1">ISBN</div>
			<div class="column addbook-column col-md-3"><input type="text" name="bookIsbn" id="bookIsbn"/></div>
			<div class="column addbook-column col-md-1">价格</div>
			<div class="column addbook-column col-md-3"><input type="number" name="bookPrice" id="bookPrice"/></div>
		</div>
		<div class="row addbook-row">
			<div class="column addbook-column col-md-1">出版社</div>
			<div class="column addbook-column col-md-3"><input type="text" name="bookPress" id="bookPress" class="ui-autocomplete"/></div>
			<div class="column addbook-column col-md-1">出版日期</div>
			<div class="column addbook-column col-md-3"><input type="date" name="publishDate" id="publishDate"/></div>
			<div class="column addbook-column col-md-1">印刷日期</div>
			<div class="column addbook-column col-md-3"><input type="date" name="printDate" id="printDate"/></div>
		</div>
		<div class="row addbook-row">
			<div class="column addbook-column col-md-1">版本</div>
			<div class="column addbook-column col-md-3"><input type="number" name="bookVersion" id="bookVersion"/></div>
			<div class="column addbook-column col-md-1">作者</div>
			<div class="column addbook-column col-md-3"><input type="text" name="bookAuthor" id="bookAuthor"/></div>
			<div class="column addbook-column col-md-1">图片</div>
			<div class="column addbook-column col-md-3"><input type="file" name="bookImage" id="bookImage"/></div>
		</div>
		<div class="row addbook-row" >
			<div class="column addbook-column col-md-1">说明</div>
		</div>
		<div class="row addbook-row">
			<div class="column addbook-column col-md-12"><input type="text" name="bookMsg" id="bookMsg" /></div>
		</div>
		<div class="row addbook-row">
			<div class="column addbook-column col-md-5"></div>
			<div class="column addbook-column col-md-2"><input type="button" value="提交" id="commit"/></div>
			<div class="column addbook-column col-md-5"></div>
		</div>
	</div>
</div>
<input type="hidden" id="pressId" />
<input type="hidden" id="authorId" />
<input type="hidden" id="imagePath" />
</body>
<script type="text/javascript">
$("#bookPress").autocomplete({
    source: function(request, response) {
    	var url = "press/presses/" + request.term + ".json";
    	var args = {
    			"time" : new Date()
    	}
    	$.get(url,args,function(data) {
    		data = eval("("+data+")");
    		response($.map(data.message, function(item) {
				return {
					id : item.id,
					label : item.name,
					name : item.name
				};
			}));
    	});
	},
	select: function(event, ui){
	    // 这里的this指向当前输入框的DOM元素
	    // event参数是事件对象
	    // ui对象只有一个item属性，对应数据源中被选中的对象
	    $(this).value = ui.item.label;
	    $(this).val(ui.item.label);
	    $("#pressId").val(ui.item.id );
	    // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
	    event.preventDefault();     
	}
});

$("#bookAuthor").autocomplete({
    source: function(request, response) {
    	var url = "author/authors/" + request.term + ".json";
    	var args = {
    			"time" : new Date()
    	}
    	$.get(url,args,function(data) {
    		var authorData = eval("("+data+")");
    		response($.map(authorData.message, function(item) {
				return {
					id : item.id,
					label : item.name,
					name : item.name
				};
			}));
    	});
	},
	select: function(event, ui){
	    // 这里的this指向当前输入框的DOM元素
	    // event参数是事件对象
	    // ui对象只有一个item属性，对应数据源中被选中的对象
	    $(this).value = ui.item.label;
	    $(this).val(ui.item.label);
	    $("#authorId").val(ui.item.id );
	    // 必须阻止事件的默认行为，否则autocomplete默认会把ui.item.value设为输入框的value值
	    event.preventDefault();     
	}
});



$("#commit").click(function() {
	var book=new Object();
	book.name 		= $("#bookName").val();
	book.price   	= $("#bookPrice").val();
	book.isbn    	= $("#bookIsbn").val();
	book.pressId   	= $("#pressId").val();
	book.publishDate = $("#publishDate").val();
	book.printDate   = $("#printDate").val();
	book.version 	= $("#bookVersion").val();
	book.authorId 	= $("#authorId").val();
	book.imagePath 	= $("#imagePath").val();
	book.msg 		= $("#bookMsg").val();
	var url = "admin/book/add.action";
	$.ajax({
		type : "POST",
		url : url,
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(book),
		success : function(data) {
			if(data == 'SUCCESS') {
				alert("保存成功！");
				changeCenterGet("admin/books/1/5.json");
			} else {
				alert("保存失败！");
			}
		}
	});
});
</script>
</html>