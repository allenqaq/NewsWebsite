package newsServlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����filter������  �ַ�  ת�� ����
//����Ŀ����utf-8
//�ο������ϵ�����
public class CharEncoding implements Filter
{
	private FilterConfig fg;

	public void destroy()
	{
		this.fg = null;

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.fg = filterConfig;

	}

}
