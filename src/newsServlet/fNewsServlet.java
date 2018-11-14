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

//����ǰ̨���ŵ�һЩ����
//���õ�½�Ϳ��Բ���
//���࣬�ؼ��ֵ�
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
		
		//������ȡ����
		if ("getNewsBySort".equals(action))
		{
			//ȡ�÷���ID
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			//�����ݿ�����
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

			//�ظ�
			Pagination<News> newsPage = new Pagination<News>();
			newsList = newsPage.splitPage(newsList, "news", pageNumber);
			request.setAttribute("page", pageNumber);
			request.setAttribute("totalPage", newsPage.getTotalPage());
			request.setAttribute("newsList", newsList);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String time = sdf.format(new Date());
			request.setAttribute("time", time);
			request.setAttribute("sortId", sortId);
			//��תҳ��
			foward = "/fNews/selectBigSort.jsp";
		}
		//�û������ݣ�������⣩
		else if ("detail".equals(action))
		{
			//ȡ��Ҫ��id
			int newsId = Integer.parseInt(request.getParameter("newsId"));
			news = NewsDAO.getNewsByID(newsId);
			request.setAttribute("news", news);
			foward = "/fNews/selectNewsContent.jsp";

		}
		//���˹��������
		else if ("NoticeDetail".equals(action))
		{
			//Ҫ�򿪵� ����id
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			notice = NoticeDAO.getNoticeByID(noticeId);
			request.setAttribute("notice", notice);
			foward = "/fAffiche/selectAfficheContent.jsp";

		}
		//��������
		else if ("FocusDetail".equals(action))
		{
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			focus = FocusDAO.getFocusByID(focusId);
			request.setAttribute("focus", focus);
			foward = "/fForce/frontSelectForce.jsp";

		}
		//�ؼ�������
		else if ("search".equals(action))
		{
			//ȡ�ùؼ���
			String key = request.getParameter("key");
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			// System.out.println(sortId);
			
			//���ݿ�Ĵ���  
			//��dao���ҳ���������������
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

			//�ظ�ҳ��Ĵ���
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
		
		//�����������
		else if ("getTodayNews".equals(action))
		{
			newsList = NewsDAO.getAllNews();
			List<News> todayNews = new ArrayList<News>();
			//��ȡʱ��
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			String time = sdf.format(new Date());
			
			//�Ա�ʱ��
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
