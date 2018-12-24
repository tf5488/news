<%@page import="entity.Newsusers"%>
<%@page import="service.UserService"%>
<%@page import="Dao.NewsUserDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String username = request.getParameter("username");
	String upwd = request.getParameter("upwd");

	UserService userservice = new UserService();
	Newsusers user = userservice.dologin(username, upwd);
	if (user != null) {
		session.setAttribute("Newsusers", user);
		session.setMaxInactiveInterval(10 * 60); 
		response.sendRedirect("newspages/admin.jsp");
	} else {
		String msg = "用户名或密码输入有误!!";
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request,
				response);
	}
%>

