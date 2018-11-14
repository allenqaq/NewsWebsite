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

//设置filter来处理  字符  转换 问题
//本项目均用utf-8
//参考了网上的资料
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
