package newsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jms.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Focus;
import beans.News;
import beans.Notice;
import beans.Sort;

import dao.FocusDAO;
import dao.NewsDAO;
import dao.NoticeDAO;
import dao.SortDAO;


//主界面的功能的处理
//前台
//新闻的分类
public class indexServlet extends HttpServlet
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

		//新闻的分类
		ArrayList<News> szNews = NewsDAO.getNewsBySortID(1);
		ArrayList<News> jjNews = NewsDAO.getNewsBySortID(2);
		ArrayList<News> kxNews = NewsDAO.getNewsBySortID(3);
		ArrayList<News> fzNews = NewsDAO.getNewsBySortID(4);
		ArrayList<News> shNews = NewsDAO.getNewsBySortID(5);
		ArrayList<News> ylNews = NewsDAO.getNewsBySortID(6);
		ArrayList<Focus> focusList = FocusDAO.getAllFocus();
		ArrayList<Notice> noticeList = NoticeDAO.getAllNotice();
		//时政
		request.setAttribute("szNews", szNews);
		//经济
		request.setAttribute("jjNews", jjNews);
		//科学
		request.setAttribute("kxNews", kxNews);
		//法制
		request.setAttribute("fzNews", fzNews);
		//社会
		request.setAttribute("shNews", shNews);
		//娱乐
		request.setAttribute("ylNews", ylNews);

		HttpSession session = request.getSession();

		//时政新闻
		if (szNews != null && !szNews.isEmpty())
		{
			session.setAttribute("szNewsCount", szNews.size());
		}
		else
		{
			session.setAttribute("szNewsCount", 0);
		}

		//经济
		if (jjNews != null && !jjNews.isEmpty())
		{
			session.setAttribute("jjNewsCount", jjNews.size());
		}
		else
		{
			session.setAttribute("jjNewsCount", 0);
		}

		//科学
		if (kxNews != null && !kxNews.isEmpty())
		{
			session.setAttribute("kxNewsCount", kxNews.size());
		}
		else
		{
			session.setAttribute("kxNewsCount", 0);
		}

		//法制新闻
		if (fzNews != null && !fzNews.isEmpty())
		{
			session.setAttribute("fzNewsCount", fzNews.size());
		}
		else
		{
			session.setAttribute("fzNewsCount", 0);
		}

		//社会新闻
		if (shNews != null && !shNews.isEmpty())
		{
			session.setAttribute("shNewsCount", shNews.size());
		}
		else
		{
			session.setAttribute("shNewsCount", 0);
		}

		//娱乐
		if (ylNews != null && !ylNews.isEmpty())
		{
			session.setAttribute("ylNewsCount", ylNews.size());
		}
		else
		{
			session.setAttribute("ylNewsCount", 0);
		}
		
		//焦点
		session.setAttribute("focusList", focusList);
		
		//公告
		session.setAttribute("noticeList", noticeList);
		
		//在dao中处理分类
		ArrayList<Sort> sortList = SortDAO.getAllSort();
		session.setAttribute("sortList", sortList);
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher("indexResult.jsp");
		rd.forward(request, response);

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
