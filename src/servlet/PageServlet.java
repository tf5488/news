package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.News;

import service.NewService;
import util.PageBean;

public class PageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	NewService newservice = new NewService();
	private String msg;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int first = 1;
		int pageNo = 8;
		String pageNoStr = request.getParameter("first");
		if (pageNoStr != null) {
			first = Integer.parseInt(pageNoStr);
		}
		msg = (String)request.getAttribute("msg");
		PageBean<News> pagebean = newservice.newsPage(first, pageNo);
		List<News> gnlist = newservice.findByTopic(1);
		List<News> gjlist = newservice.findByTopic(2);
		List<News> yllist = newservice.findByTopic(5);
		request.setAttribute("gnlist", gnlist);
		request.setAttribute("gjlist", gjlist);
		request.setAttribute("yllist", yllist);
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
