package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewService;
import service.TopicService;

import entity.News;
import entity.Topic;

public class NewsModifyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8546400898445938431L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int ntid = Integer.parseInt(request.getParameter("ntid"));
		TopicService topservice = new TopicService();
		Topic top1 = topservice.findById(ntid);
		int nid = Integer.parseInt(request.getParameter("nid"));
		NewService newservice = new NewService();
		News news = newservice.findById(nid);
		
		topservice = new TopicService();
		List<Topic> list = topservice.showAll();
		
		request.setAttribute("nid", nid);
		request.setAttribute("top1", top1);
		request.setAttribute("news", news);
		request.setAttribute("list", list);
		request.getRequestDispatcher("news_modify.jsp").forward(request, response);
	}

}
