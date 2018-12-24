<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="../js/jquery-1.12.4.js"></script>
<script >
	$(function(){
		$.ajax({
			url : "TopicListServlet",
			type : "get",
			dataType : "json",
			success:function(ret){
				$(ret).each(function(){
					 $(".classlist").append("<li>&#160;&#160;&#160;&#160;"
					 +this.name
					 +" &#160;&#160;&#160;&#160;<a href='topic_modify.jsp?tid="
					 +this.tid
					 +"&tname="
					 +this.name
					 +">'>修改</a>&#160;&#160;&#160;&#160; <a href='TopicServlet?pro=del&tid="
					 +this.tid
					 +"'>删除</a></li>");
				});
			},
			error:function(){
				alert("error!");
			}
		});
	
	});
</script>
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	${msg }
	<%@include file="console_element/top.jsp"%>
	<div id="main">
		<%@include file="console_element/left.jsp"%>
		<div id="opt_area">
			<ul class="classlist">
				<%-- <c:forEach items="${list }" var="list">
				<li>&#160;&#160;&#160;&#160;${list.tname } &#160;&#160;&#160;&#160;
					<a
					href='topic_modify.jsp?tid=${list.tid }&tname=${list.tname }>'>修改</a>
					&#160;&#160;&#160;&#160; <a
					href='TopicServlet?pro=del&tid=${list.tid }'>删除</a></li>
				</c:forEach> --%>
			</ul>
		</div>
	</div>
	<div id="footer">
		<%@include file="console_element/bottom.html"%>
	</div>
</body>
</html>
