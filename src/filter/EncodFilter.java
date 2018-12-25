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
		System.out.println("ִ�г�ʼ��!");
		charset = config.getInitParameter("charset");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// �����ܵ����ݽ���ǿת
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		
		// ���в���
		request.setCharacterEncoding(charset);
		response.setContentType("text/html;charset="+charset);
		
		// �����ݴ��ݳ�ȥ
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("ִ������!");
		charset = null;
	}

}
