<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.*s" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<title>添加主题--管理后台</title>
<link href="../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<c:if test="${empty pagebean }">
		<script type="text/javascript">
			location.href = "AdminServlet";
		</script>
	</c:if>
	<jsp:include page="console_element/top.jsp"></jsp:include>
	<div id="main">
		<jsp:include page="console_element/left.jsp"></jsp:include>
		<div id="opt_area">
			<script language="javascript">
				function clickdel() {
					return confirm("删除请点击确认");
				}
			</script>
			<ul class="classlist">
				<c:forEach items="${pagebean.pageList }" var="page">
					<li>${page.ntitle } <span> 作者： ${page.nauthor }
							&#160;&#160;&#160;&#160; 
							<a href='news_modify.jsp?ntid=${page.ntid }&nid=${page.nid }'>修改</a>
							&#160;&#160;&#160;&#160; 
							<a href='NewServlet?pro=del&nid=${page.nid }'>删除</a> </span>
					</li>
				</c:forEach>
				<p align="right">
					当前页数:[${pagebean.pageNo }/${pagebean.totalPages }]&nbsp; 
						<a href="AdminServlet">首页</a> 
						<a href="AdminServlet?first=${pagebean.pageNo-1 }">上一页</a> 
						<a href="AdminServlet?first=${pagebean.pageNo+1 }">下一页</a> 
						<a href="AdminServlet?first=${pagebean.totalPages }">末页</a>
				</p>
			</ul>
		</div>
	</div>
	<div id="footer">
		<%@include file="console_element/bottom.html"%>
	</div>
</body>
</html>
