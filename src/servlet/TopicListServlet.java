package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.Topic;

import service.TopicService;

public class TopicListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6091148689395957866L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TopicService topservice = new TopicService();
		
		List<Topic> list = topservice.showAll();
		/*StringBuffer jsonSB = new StringBuffer("[");
		for(int i = 0 ; i < list.size();i++){
			Topic topic = list.get(i);
			if(i  == list.size()-1){
				jsonSB.append("{\"tid\":"+topic.getTid());
				jsonSB.append(",\"name\":\""+topic.getTname());
				jsonSB.append("\"}");
			}else{
				jsonSB.append("{\"tid\":"+topic.getTid());
				jsonSB.append(",\"name\":\""+topic.getTname());
				jsonSB.append("\"},");
			}
		}
		jsonSB.append("]");*/
		PrintWriter out = response.getWriter();
		String jsonSB = JSON.toJSONString(list);
		System.out.println(jsonSB.toString());
		out.println(jsonSB.toString());
		out.flush();
		out.close();
		/*request.setAttribute("list", list);
		request.getRequestDispatcher("topic_list.jsp").forward(request,	response);*/
	}

}
