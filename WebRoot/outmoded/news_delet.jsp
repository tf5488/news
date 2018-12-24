<%@page import="service.NewService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	NewService newservice = new NewService();
	int nid = Integer.parseInt(request.getParameter("nid"));
	String msg = newservice.deletNew(nid);
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("admin.jsp").forward(request,
			response);
%>
