package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewService;

public class NewServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2794800891464655524L;
	
	NewService newservice = new NewService();
	Date ncreatedate = new Date(); // java.util.date

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doget");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pro = request.getParameter("pro");
		if (pro.equals("add")) {
			int ntid = Integer.parseInt(request.getParameter("ntid"));
			String ntitle = request.getParameter("ntitle");
			String nauthor = request.getParameter("nauthor");
			// Date date = new Date(); // java.util.date 传入Java.util.date
			// 时间,后续改过来

			String nsummary = request.getParameter("nsummary");
			String msg = newservice.addNew(ntid, ntitle, nauthor, ncreatedate,
					nsummary);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("news_add.jsp").forward(
					request, response);
		}
		if (pro.equals("change")) {
			int nid = Integer.parseInt(request.getParameter("nid"));
			int ntid = Integer.parseInt(request.getParameter("ntid"));
			String ntitle = request.getParameter("ntitle");
			String nauthor = request.getParameter("nauthor");
			// Date date = new Date(); // java.util.date 传入Java.util.date
			// 时间,后续改过来
			String nsummary = request.getParameter("nsummary");
			String msg = newservice.changeNew(nid, ntid, ntitle, nauthor,
					ncreatedate, nsummary);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("admin.jsp")
					.forward(request, response);
		}
		if (pro.equals("del")) {
			int nid = Integer.parseInt(request.getParameter("nid"));
			String msg = newservice.deletNew(nid);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("admin.jsp")
					.forward(request, response);
		}

	}

}
