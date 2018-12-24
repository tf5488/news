<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新闻中国</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("TopicListServlet",function(ret){
			$(ret).each(function(){
				//alert("aa");
				$("#class_month").append("<a name='topiclsit' href='#' tid='"+this.tid+"'><b>"+this.tname+" </b> </a> ");
			});
			
		});
	
		$("#topiclsit").click(function(){
			var tid = $(this).attr("tid");
			var url = "NewListServlet?tid="+tid;
			$.getJSON(url,function(ret){
				$(".classlist").html("");
				$(".classlist").append("<li><a href='#'>"+
					this.ntitle+" </a><span>"+
					this.ncreateDate+"</span></li>");
			});
		});
	});

</script>
<c:if test="${empty pagebean }">
	<script type="text/javascript">
		location.href = "PageServlet";
	</script>
</c:if>
</head>
<body>
	
	<div id="header">
		${msg }
		<div id="top_login">
			<form id="login" method="post" action="UserServlet">
				<label>登录名</label><input type="text" name="username" value=""
					class="login_input" /> <label>密&#160;&#160;码</label><input
					type="password" name="upwd" value="" class="login_input" /> <input
					type="submit" class="login_sub" value="登录" />
			</form>
			<img src="images/friend_logo.gif" alt="Google" id="friend_logo" />
		</div>
		<div id="nav">
			<div id="logo">
				<img src="images/logo.jpg" alt="新闻中国" />
			</div>
			<div id="a_b01">
				<img src="images/a_b01.gif" alt="" />
			</div>
			<!--mainnav end-->
		</div>
	</div>
	<div id="container">
		<div class="sidebar">
			<h1>
				<img src="images/title_1.gif" alt="国内新闻" />
			</h1>
			<div class="side_list">
				<c:forEach items="${gnlist }" var="gn">
				<ul>
						<li><a href='#'><b>${gn.ntitle }</b> </a></li>
				</ul>
				</c:forEach>
			</div>
			<h1>
				<img src="images/title_2.gif" alt="国际新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${gjlist }" var="gj">
						
						<li><a href='#'><b> ${gj.ntitle }</b> </a></li>
					</c:forEach>
				</ul>
			</div>
			<h1>
				<img src="images/title_3.gif" alt="娱乐新闻" />
			</h1>
			<div class="side_list">
				<ul>
					<c:forEach items="${yllist }" var="yl">
						<li><a><b> ${yl.ntitle } </b> </a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="main">
			<div class="class_type">
				<img src="images/class_type.gif" alt="新闻中心" />
			</div>
			<div class="content">
				<ul class="class_date">
					<li id='class_month'>
					
					</li>
				</ul>
				<ul class="classlist">
					<c:forEach items="${pagebean.pageList }" var="pagebean">
						<li><a href='#'>${pagebean.ntitle } </a><span>${pagebean.ncreateDate
								}</span>
						</li>
					</c:forEach>

					<li class='space'></li>

					<p align="right">
						当前页数:[${pagebean.pageNo }/${pagebean.totalPages }]&nbsp;
						<a href="PageServlet">首页</a> <a
							href="PageServlet?first=${pagebean.pageNo-1 }">上一页</a> <a
							href="PageServlet?first=${pagebean.pageNo+1 }">下一页</a>
						<a href="PageServlet?first=${pagebean.totalPages }">末页</a>
					</p>
				</ul>
			</div>
			<div class="picnews">
				<ul>
					<li><a href="#"><img src="images/Picture1.jpg" width="249"
							alt="" /> </a><a href="#">幻想中穿越时空</a></li>
					<li><a href="#"><img src="images/Picture2.jpg" width="249"
							alt="" /> </a><a href="#">国庆多变的发型</a></li>
					<li><a href="#"><img src="images/Picture3.jpg" width="249"
							alt="" /> </a><a href="#">新技术照亮都市</a></li>
					<li><a href="#"><img src="images/Picture4.jpg" width="249"
							alt="" /> </a><a href="#">群星闪耀红地毯</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="friend">
		<h1 class="friend_t">
			<img src="images/friend_ico.gif" alt="合作伙伴" />
		</h1>
		<div class="friend_list">
			<ul>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
				<li><a href="#">中国政府网</a></li>
			</ul>
		</div>
	</div>
	<div id="footer">
		<p class="">
			24小时客户服务热线：010-68988888 &#160;&#160;&#160;&#160; <a href="#">常见问题解答</a>
			&#160;&#160;&#160;&#160; 新闻热线：010-627488888 <br />
			文明办网文明上网举报电话：010-627488888 &#160;&#160;&#160;&#160; 举报邮箱： <a href="#">jubao@jb-aptech.com.cn</a>
		</p>
		<p class="copyright">
			Copyright &copy; 1999-2009 News China gov, All Right Reserver <br />
			新闻中国 版权所有
		</p>
	</div>
</body>
</html>
