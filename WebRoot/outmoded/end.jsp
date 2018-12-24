<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	request.setCharacterEncoding("utf-8");
	Integer count = Integer.parseInt(request.getParameter("count"));
	Integer end = Integer.parseInt(request.getParameter("size"));
	request.setAttribute("count", count);
	request.setAttribute("end", end);
	request.getRequestDispatcher("admin.jsp")
			.forward(request, response);
%>