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


//�����servlet
//���ŵķ��ࣨ���������ֵȣ�
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

		//ȡ���з���
		if ("getAllSort".equals(action))
		{
			pageSplit(request);

		}
		
		//��ӷ���
		else if ("add".equals(action))
		{
			String sortName = request.getParameter("sortName");
			sort = new Sort();
			sort.setSortName(sortName);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sort.setCreateTime(sdf.format(new Date()));
			
			//���ݿ� dao�Ĳ���
			if (SortDAO.SortAdd(sort))
			{
				message = "������ӳɹ�";
			}
			else
			{
				message = "�������ʧ��";
			}
			pageSplit(request);

		}
		
		//ȡ���ַ���
		else if ("getSort".equals(action))
		{
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			sort = SortDAO.getSortByID(sortId);
			request.setAttribute("sort", sort);
			forward = "/bSort/updateSort.jsp";
		}
		
		//�޸ķ���
		else if ("update".equals(action))
		{
			int sortId = Integer.parseInt(request.getParameter("sortId"));
			String sortName = request.getParameter("sortName");
			sort = new Sort();
			sort.setSortId(sortId);
			sort.setSortName(sortName);
			if (SortDAO.SortUpdate(sort))
			{
				message = "�����޸ĳɹ�";
			}
			else
			{
				message = "�����޸�ʧ��";
			}
			pageSplit(request);

		}
		
		//ɾ������
		else if ("delete".equals(action))
		{

			int sortId = Integer.parseInt(request.getParameter("sortId"));
			System.out.println(sortId);
			if (SortDAO.SortDelete(sortId))
			{
				message = "����ɾ���ɹ�";
			}
			else
			{
				message = "����ɾ��ʧ��";
			}
			pageSplit(request);

		}
		request.setAttribute("message", message);
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	
	//��ҳ�ĺ���
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
