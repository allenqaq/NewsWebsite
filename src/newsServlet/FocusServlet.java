package newsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Pagination;

import dao.FocusDAO;
import dao.NewsDAO;

import beans.Focus;
import beans.News;
import beans.Sort;

//焦点新闻的处理
//添加删除等
public class FocusServlet extends HttpServlet
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

		//页面的设置
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		String forward = "/bForce/selectForce.jsp";
		RequestDispatcher rd = null;
		ArrayList<Focus> focusList = null;

		//要查询所有焦点新闻
		if ("getAllFocus".equals(action))
		{
			pageSplit(request);
		}
		
		//查看分类的焦点新闻
		else if ("getFocus".equals(action))
		{
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			Focus focus = FocusDAO.getFocusByID(focusId);
			request.setAttribute("focus", focus);
			forward = "/bForce/updateForce.jsp";

		}
		//添加
		else if ("add".equals(action))
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Focus focus = new Focus();
			focus.setFocusTitle(title);
			focus.setFocusContent(content);
			//时间设置
			SimpleDateFormat timeFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String time = timeFormat.format(new java.util.Date());
			focus.setCreateTime(time);
			if (FocusDAO.FocusAdd(focus))
			{
				request.setAttribute("message", "焦点新闻添加成功");
			}
			else
			{
				request.setAttribute("message", "焦点新闻添加失败");

			}
			pageSplit(request);

		}
		
		//更新
		else if ("update".equals(action))
		{
			//数据的初始化
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Focus focus = new Focus();
			focus.setFocusTitle(title);
			focus.setFocusContent(content);
			focus.setFocusID(focusId);
			if (FocusDAO.FocusUpdate(focus))
			{
				request.setAttribute("message", "焦点新闻修改成功");

			}
			else
			{
				request.setAttribute("message", "焦点新闻修改失败");

			}
			pageSplit(request);
		}
		
		//删除
		else if ("delete".equals(action))
		{
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			if (FocusDAO.FocusDelete(focusId))
			{
				request.setAttribute("message", "焦点新闻删除成功");

			}
			else
			{
				request.setAttribute("message", "焦点新闻删除失败");

			}
			pageSplit(request);

		}
		
		//点击标题
		//要显示内容
		else if ("getDetail".equals(action))
		{
			int focusId = Integer.parseInt(request.getParameter("focusId"));
			Focus focus = FocusDAO.getFocusByID(focusId);
			request.setAttribute("focus", focus);
			forward = "/bForce/selectForceContent.jsp";

		}
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	//分页的处理
	private void pageSplit(HttpServletRequest request)
	{
		List<Focus> focusList;
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

		focusList = FocusDAO.getAllFocus();
		Pagination<Focus> focusPage = new Pagination<Focus>();
		focusList = focusPage.splitPage(focusList, "focus", pageNumber);
		request.setAttribute("page", pageNumber);
		request.setAttribute("totalPage", focusPage.getTotalPage());
		request.setAttribute("focusList", focusList);
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
