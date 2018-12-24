<%@page import="service.TopicService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String tname = request.getParameter("tname");
	int tid = Integer.parseInt(request.getParameter("tid")); // 转换接受类型
	tname = new String(tname.getBytes("ISO-8859-1"),"utf-8"); 
	out.print(tname+"++++"+tid);
	TopicService topservice = new TopicService();
	String msg = topservice.changeTopic(tid, tname);
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("topic_list.jsp").forward(request,
				response);
%>


