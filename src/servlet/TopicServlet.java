package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TopicService;

public class TopicServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8450556769804680040L;
	TopicService topservice = new TopicService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tname = request.getParameter("tname");
		String pro = request.getParameter("pro");
		if (pro.equals("add")) {
			System.out.println("add");
			String msg = topservice.addTopic(tname);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("topic_add.jsp").forward(request,
					response);
		}
		if (pro.equals("change")) {
			System.out.println("change");
			int tid = Integer.parseInt(request.getParameter("tid")); // 转换接受类型
			tname = new String(tname.getBytes("ISO-8859-1"), "utf-8");
			String msg = topservice.changeTopic(tid, tname);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("TopicListServlet").forward(request,
					response);
		}
		if (pro.equals("del")) {
			int tid = Integer.parseInt(request.getParameter("tid")); // 转换接受类型
			String msg = topservice.deletTopic(tid);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("topic_list.jsp").forward(request,
					response);
		}
	}

}
