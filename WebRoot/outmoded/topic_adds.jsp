<%@page import="service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	request.setCharacterEncoding("utf-8");
	String tname = request.getParameter("tname");
	//tname = new String(tname.getBytes("ISO-8859-1"), "utf-8");
	TopicService topservice = new TopicService();
	String msg = topservice.addTopic(tname);
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("topic_add.jsp").forward(request,
			response);
%>
