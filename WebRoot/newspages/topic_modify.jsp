<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="console_element/top.jsp"%>

<script type="text/javascript">
	function check(){
		var tname = document.getElementById("tname");

		if(tname.value == ""){
			alert("请输入主题名称！！");
			tname.focus();
			return false;
		}		
		return true;
	}
</script>

<div id="main">
	<%@include file="console_element/left.jsp"%>
	<div id="opt_area">
		<h1 id="opt_type">修改主题：</h1>
		<form action="TopicServlet?pro=change" method="post"
			onsubmit="return check()">
			<p>
				<label> 主题名称 </label> <input name="tname" id="tname" type="text"
					class="opt_input" value="${tname }" /> <input name="tid"
					type="hidden" value="${tid }" />
			</p>
			<input name="action" type="hidden" value="addtopic" /> <input
				type="submit" value="提交" class="opt_sub" /> <input type="reset"
				value="重置" class="opt_sub" />
		</form>
	</div>
</div>
<%@include file="console_element/bottom.html"%>
