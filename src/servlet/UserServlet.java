package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Newsusers;

import service.UserService;

public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserService userservice = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String upwd = request.getParameter("upwd");

		Newsusers user = userservice.dologin(username, upwd);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(10 * 60);
			response.sendRedirect("newspages/AdminServlet");
		} else {
			String msg = "用户名或密码输入有误!!";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("PageServlet")
					.forward(request, response);
		}
	}

}
