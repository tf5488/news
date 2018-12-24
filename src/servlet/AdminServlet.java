package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewService;
import util.PageBean;
import entity.News;
import entity.Newsusers;

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3415672678917168125L;

	NewService newservice = new NewService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int first = 1;
		int pageNo = 8;
		System.out.println("AdminServlet");
		Newsusers user = (Newsusers)request.getSession().getAttribute("user");
		String pageNoStr = request.getParameter("first");
		if (pageNoStr != null) {
			first = Integer.parseInt(pageNoStr);
		}
		PageBean<News> pagebean = newservice.newsPage(first, pageNo);
		
		System.out.println("pagebean.getPageList().size()"+pagebean.getPageList().size());
		request.setAttribute("user", user);
		request.setAttribute("pagebean", pagebean);
		
		request.getRequestDispatcher("admin.jsp").forward(request, response);
		
	}
}
