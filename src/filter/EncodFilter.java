package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EncodFilter implements filter{
	private String charset;
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("执行初始化!");
		charset = config.getInitParameter("charset");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 将接受的数据进行强转
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		// 进行操作
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		
		// 将数据传递出去
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("执行销毁!");
		charset = null;
	}

}
