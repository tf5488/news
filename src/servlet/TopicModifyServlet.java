package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicModifyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2871164518452323680L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tname = request.getParameter("tname");
		tname = new String(tname.getBytes("ISO-8859-1"), "utf-8");
		String tid = request.getParameter("tid");
		
		request.setAttribute("tid", tid);
		request.setAttribute("tname", tname);
		request.getRequestDispatcher("topic_modify.jsp").forward(request,	response);
		
	}

}
