package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import entity.News;

import service.NewService;

public class NewListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8294244312449204189L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		NewService newservice = new NewService();
		List<News> list = null;
		Integer tid = Integer.parseInt(request.getParameter("tid"));
		if(tid == null){
			list = newservice.showAll();
		}else{
			list = newservice.findByTopic((int)tid);
		}
		PrintWriter out = response.getWriter();
		String jsonStr = JSON.toJSONString(list,SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullNumberAsZero,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteDateUseDateFormat);
		out.println(jsonStr);
		out.flush();
		out.close();
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("new_list.jsp").forward(request, response);*/
	}

}
