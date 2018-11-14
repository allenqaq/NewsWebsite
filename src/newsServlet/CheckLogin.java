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

import beans.Manager;

//检查是否登陆
//实现 filter类
public class CheckLogin implements Filter
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
		Manager m = (Manager) req.getSession().getAttribute("manager");
		if (null != m && null != m.getAccount() && !"".equals(m.getAccount()))
		{
			chain.doFilter(req, res);
		}
		else
		{
			res.sendRedirect("/news/index.jsp");
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException
	{
		this.fg = filterConfig;
	}

}
