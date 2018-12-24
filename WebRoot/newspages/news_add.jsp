<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>

<body>
	${msg }
	<%@include file="console_element/top.jsp"%>
	<div id="main">
		<%@include file="console_element/left.jsp"%>
		<div id="opt_area">
			<h1 id="opt_type">添加新闻：</h1>
			<form action="NewServlet?pro=add" method="post">
				<p>
					<label> 主题 </label> <select name="ntid" id="ntid">
						<c:forEach items="${list }" var="list">
						<option value=${list.tid }>${list.tname }</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<label> 标题 </label> <input name="ntitle" id="ntitle" type="text"
						class="opt_input" />
				</p>
				<p>
					<label> 作者 </label> <input name="nauthor" id="nauthor" type="text"
						class="opt_input" />
				</p>
				<p>
					<label> 摘要 </label>
					<textarea name="nsummary" id="nsummary" cols="40" rows="3"></textarea>
				</p>
				<p>
					<label> 内容 </label>
					<textarea name="ncontent" id="ncontent" cols="70" rows="10"></textarea>
				</p>
				<p>
					<label> 上传图片 </label> <input type="file" name="nfile" />
				</p>
				<input type="submit" value="提交" class="opt_sub" /> <input
					type="reset" value="重置" class="opt_sub" />
			</form>
		</div>
	</div>
	<div id="footer">
		<%@include file="console_element/bottom.html"%>
	</div>
</body>
</html>
