package newsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Pagination;

import dao.FocusDAO;
import dao.NewsDAO;
import dao.NoticeDAO;

import beans.Focus;
import beans.News;
import beans.Notice;

//对于前台新闻的一些处理
//不用登陆就可以操作
//分类，关键字等
public class fNewsServlet extends HttpServlet
{

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		RequestDispatcher rd = null;
		List<News> newsList = new ArrayList<News>();
		News news = null;
		Notice notice = null;
		Focus focus = null;
		String foward = "";
		
		//按分类取新闻
		if ("getNewsBySort".equals(action))
		{
			//取得分类ID
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			//与数据库连接
			newsList = NewsDAO.getNewsBySortID(sortId);
			Integer pageNumber;
			String page = request.getParameter("page");
			if (null == page || "".equals(page))
			{
				pageNumber = 1;
			}
			else
			{
				pageNumber = Integer.parseInt(page);
			}

			//回复
			Pagination<News> newsPage = new Pagination<News>();
			newsList = newsPage.splitPage(newsList, "news", pageNumber);
			request.setAttribute("page", pageNumber);
			request.setAttribute("totalPage", newsPage.getTotalPage());
			request.setAttribute("newsList", newsList);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());
			request.setAttribute("time", time);
			request.setAttribute("sortId", sortId);
			//跳转页面
			foward = "/fNews/selectBigSort.jsp";
		}
		//用户打开内容（点击标题）
		else if ("detail".equals(action))
		{
			//取得要的id
			int newsId = Integer.parseInt(request.getParameter("newsId"));
			news = NewsDAO.getNewsByID(newsId);
			request.setAttribute("news", news);
			foward = "/fNews/selectNewsContent.jsp";

		}
		//打开了公告的内容
		else if ("NoticeDetail".equals(action))
		{
			//要打开的 新闻id
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			notice = NoticeDAO.getNoticeByID(noticeId);
			request.setAttribute("notice", notice);
			foward = "/fAffiche/selectAfficheContent.jsp";

		}
		//焦点内容
		else if ("FocusDetail".equals(action))
		{
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			focus = FocusDAO.getFocusByID(focusId);
			request.setAttribute("focus", focus);
			foward = "/fForce/frontSelectForce.jsp";

		}
		//关键字搜索
		else if ("search".equals(action))
		{
			//取得关键字
			String key = request.getParameter("key");
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			// System.out.println(sortId);
			
			//数据库的处理  
			//在dao中找出符合条件的数据
			newsList = NewsDAO.getNewsByNewsTitleandSortID(key, sortId);
			
			// System.out.println(newsList);
			Integer pageNumber;
			String page = request.getParameter("page");
			if (null == page || "".equals(page))
			{
				pageNumber = 1;
			}
			else
			{
				pageNumber = Integer.parseInt(page);
			}

			//回复页面的处理
			Pagination<News> newsPage = new Pagination<News>();
			newsList = newsPage.splitPage(newsList, "news", pageNumber);
			request.getSession().setAttribute("currentPage", pageNumber);
			request.getSession().setAttribute("tPage", newsPage.getTotalPage());
			request.getSession().setAttribute("key", key);
			request.getSession().setAttribute("sortId", sortId);
			request.getSession().setAttribute("keyNews", newsList);
			PrintWriter out = response.getWriter();
			out.print("<script>parent.window.location.href='../fNews/frontSelectKeyNews.jsp'</script>");

		}
		
		//点击今天新闻
		else if ("getTodayNews".equals(action))
		{
			newsList = NewsDAO.getAllNews();
			List<News> todayNews = new ArrayList<News>();
			//获取时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String time = sdf.format(new Date());
			
			//对比时间
			for (News news2 : newsList)
			{
				if (news2.getCreateTime().equals(time))
				{
					todayNews.add(news2);
				}

			}
			System.out.println(todayNews);
			Integer pageNumber;
			String page = request.getParameter("page");
			if (null == page || "".equals(page))
			{
				pageNumber = 1;
			}
			else
			{
				pageNumber = Integer.parseInt(page);
			}

			Pagination<News> newsPage = new Pagination<News>();
			todayNews = newsPage.splitPage(todayNews, "news", pageNumber);
			request.setAttribute("page", pageNumber);
			request.setAttribute("totalPage", newsPage.getTotalPage());
			request.setAttribute("todayNews", todayNews);

			foward = "../fNews/frontSelectTodayNews.jsp";

		}
		if (null != foward & !"".equals(foward))
		{
			rd = request.getRequestDispatcher(foward);
			rd.forward(request, response);
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
