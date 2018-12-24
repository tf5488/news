<%@page import="entity.Topic"%>
<%@page import="service.TopicService"%>
<%@page import="service.NewService"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	NewService newservice = new NewService();

	int ntid = Integer.parseInt(request.getParameter("ntid"));
	String ntitle = request.getParameter("ntitle");
	String nauthor = request.getParameter("nauthor");
	//Date date = new Date(); // java.util.date 传入Java.util.date 时间,后续改过来
	Date ncreatedate = new Date(); // java.mysql.date
	String nsummary = request.getParameter("nsummary");
	String msg = newservice.addNew(ntid, ntitle, nauthor, ncreatedate,
			nsummary);
	request.setAttribute("msg", msg);
	request.getRequestDispatcher("../newspages/news_add.jsp").forward(
			request, response);
%>

