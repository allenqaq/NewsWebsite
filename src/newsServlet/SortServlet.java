package newsServlet;

import java.io.IOException;

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

import dao.SortDAO;

import beans.Sort;


//分类的servlet
//新闻的分类（体育，娱乐等）
public class SortServlet extends HttpServlet
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
		Sort sort = null;
		String message = "";
		String forward = "/bSort/selectSort.jsp";

		//取所有分类
		if ("getAllSort".equals(action))
		{
			pageSplit(request);

		}
		
		//添加分类
		else if ("add".equals(action))
		{
			String sortName = request.getParameter("sortName");
			sort = new Sort();
			sort.setSortName(sortName);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sort.setCreateTime(sdf.format(new Date()));
			
			//数据库 dao的操作
			if (SortDAO.SortAdd(sort))
			{
				message = "分类添加成功";
			}
			else
			{
				message = "分类添加失败";
			}
			pageSplit(request);

		}
		
		//取部分分类
		else if ("getSort".equals(action))
		{
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			sort = SortDAO.getSortByID(sortId);
			request.setAttribute("sort", sort);
			forward = "/bSort/updateSort.jsp";
		}
		
		//修改分类
		else if ("update".equals(action))
		{
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			String sortName = request.getParameter("sortName");
			sort = new Sort();
			sort.setSortId(sortId);
			sort.setSortName(sortName);
			if (SortDAO.SortUpdate(sort))
			{
				message = "分类修改成功";
			}
			else
			{
				message = "分类修改失败";
			}
			pageSplit(request);

		}
		
		//删除分类
		else if ("delete".equals(action))
		{

			int sortId = Integer.parseInt(request.getParameter("sortId"));
			System.out.println(sortId);
			if (SortDAO.SortDelete(sortId))
			{
				message = "分类删除成功";
			}
			else
			{
				message = "分类删除失败";
			}
			pageSplit(request);

		}
		request.setAttribute("message", message);
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	
	//分页的函数
	private void pageSplit(HttpServletRequest request)
	{
		List<Sort> sortList;

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
		sortList = SortDAO.getAllSort();
		Pagination<Sort> sortPage = new Pagination<Sort>();
		sortList = sortPage.splitPage(sortList, "sort", pageNumber);
		request.setAttribute("page", pageNumber);
		request.setAttribute("totalPage", sortPage.getTotalPage());

		request.setAttribute("sortList", sortList);
		request.getSession().setAttribute("sortList", sortList);
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
