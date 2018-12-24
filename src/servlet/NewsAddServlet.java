package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Topic;

import service.TopicService;

public class NewsAddServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5757944305796601520L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TopicService topservice = new TopicService();
		List<Topic> list = topservice.showAll();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("news_add.jsp").forward(request, response);
		
	}

}
