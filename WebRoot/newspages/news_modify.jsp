<%@ page import="java.sql.*" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="console_element/top.jsp"%>
<script type="text/javascript">
	function check(){
		var ntitle = document.getElementById("ntitle");
		var nauthor = document.getElementById("nauthor");
		var nsummary = document.getElementById("nsummary");
		var ncontent = document.getElementById("ncontent");
		
		if(ntitle.value == ""){
			alert("标题不能为空！！");
			ntitle.focus();
			return false;
		}else if(nauthor.value == ""){
			alert("作者不能为空！！");
			nauthor.focus();
			return false;
		}else if(nsummary.value == ""){
			alert("摘要不能为空！！");
			nsummary.focus();
			return false;
		}else if(ncontent.value == ""){
			alert("内容不能为空！！");
			ncontent.focus();
			return false;
		}		
		return true;
	}
</script>

<div id="main">
	${msg }
	<%@include file="console_element/left.jsp"%>
	<div id="opt_area">
		<h1 id="opt_type">编辑新闻：</h1>
		<form action="NewServlet?pro=change&nid=${nid }" method="post"
			onsubmit="return check()">
			<p>
				<label> 主题 </label> <select name="ntid">
					<option value=${top1.tid }>${top1.tname }</option>
					<c:forEach items="${list }" var="list">
					<option value=${list.tid }>${list.tname }</option>
					</c:forEach>
				</select> <input type="hidden" name="nid" value=${news.nid } />
			</p>
			<p>
				<label> 标题 </label> <input name="ntitle" id="ntitle" type="text"
					class="opt_input" value=${news.ntitle } />
			</p>
			<p>
				<label> 作者 </label> <input name="nauthor" id="nauthor" type="text"
					class="opt_input" value=${news.nauthor } />
			</p>
			<p>
				<label> 摘要 </label>
				<textarea name="nsummary" id="nsummary" cols="40" rows="3">${news.nsummary }</textarea>
			</p>
			<p>
				<label> 内容 </label>
				<textarea name="ncontent" id="ncontent" cols="70" rows="10"></textarea>
			</p>
			<p>
				<label> 上传图片 </label> <input name="file" id="file" type="file"
					class="opt_input" />
			</p>
			<input type="submit" value="提交" class="opt_sub" /> <input
				type="reset" value="重置" class="opt_sub" />
		</form>
		<h1 id="opt_type">修改新闻评论：</h1>
		<table width="80%" align="left">
			<td colspan="6">暂无评论！</td>
			<tr>
				<td colspan="6"><hr /></td>
			</tr>

			<tr>
				<td>留言人：</td>
				<td></td>
				<td>IP：</td>
				<td></td>
				<td>留言时间：</td>
				<td></td>
				<td><a href="">删除</a>
				</td>
			</tr>
			<tr>
				<td colspan="6"></td>
			</tr>
			<tr>
				<td colspan="6"><hr /></td>
			</tr>
		</table>
	</div>
</div>
<%@include file="console_element/bottom.html"%>