<%@page import="service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int tid = Integer.parseInt(request.getParameter("tid")); // 转换接受类型
	TopicService topservice = new TopicService();
	String msg = topservice.deletTopic(tid);
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("topic_list.jsp").forward(request,
				response);
%>


