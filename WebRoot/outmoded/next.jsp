<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	request.setCharacterEncoding("utf-8");
	Integer count = Integer.parseInt(request.getParameter("count"));
	request.setAttribute("count", count);
	request.getRequestDispatcher("admin.jsp")
			.forward(request, response);
%>