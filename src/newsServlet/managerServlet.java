package newsServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import util.Pagination;

import dao.ManagerDAO;
import dao.NewsDAO;
import dao.NoticeDAO;
import dao.SortDAO;

import beans.Manager;
import beans.News;
import beans.Notice;
import beans.Sort;

//管理用户的servlet
//用于登陆
//以及管理员的一些处理
//添加 删除等
public class managerServlet extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");

		RequestDispatcher rd = null;
		PrintWriter out = response.getWriter();

		//登陆
		if ("login".equals(action))
		{
			//获取输入账号密码
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			Manager m = new Manager();
			m.setName(account);
			m.setAccount(account);
			m.setPassword(password);
			
			//与数据库中的对比
			m = ManagerDAO.CheckLogin(m);
			// System.out.println(m.getName());
			if (m != null)
			{
				HttpSession session = request.getSession(true);
				session.setAttribute("account", m.getAccount());
				m.setNumber(m.getNumber() + 1);
				session.setAttribute("manager", m);
				if (ManagerDAO.ManagerUpdate(m))
				{
					session.setAttribute("manager", m);
				}
				/*
				 * ArrayList<News> newsList = NewsDAO.getAllNews();
				 * session.setAttribute("nList", newsList); sortList =
				 * SortDAO.getAllSort(); session.setAttribute("sortList",
				 * sortList);
				 */
			}
			out.print("<script>parent.window.location.href='../index.jsp'</script>");

		}
		
		//添加用户
		else if ("add".equals(action))
		{
			//获取账号密码
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			Manager m = new Manager();
			m.setAccount(account);
			m.setName(name);
			m.setPassword(password);
			
			//添加到数据库中
			if (ManagerDAO.ManagerAdd(m))
			{
				request.setAttribute("message", "用户添加成功！");
			}
			else
			{
				request.setAttribute("message", "用户添加失败！");
			}
			disPatcher(request, response);
		}
		
		//查看用户
		else if ("getManager".equals(action))
		{
			int id = Integer.parseInt(request.getParameter("Id"));
			Manager m = ManagerDAO.getManagerById(id);
			request.setAttribute("manager", m);
			rd = request.getRequestDispatcher("/bManager/updateManager.jsp");
			rd.forward(request, response);
		}
		
		//更新用户的信息
		else if ("update".equals(action))
		{
			int id = Integer.parseInt(request.getParameter("Id"));
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			Manager m = new Manager();
			m.setManagerID(id);
			m.setAccount(account);
			m.setName(name);
			m.setPassword(password);
			
			//在数据库中跟新
			if (ManagerDAO.ManagerUpdate(m))
			{
				request.setAttribute("message", "用户修改成功！");
			}
			else
			{
				request.setAttribute("message", "用户修改失败！");
			}
			disPatcher(request, response);
		}
		
		//删除用户
		else if ("delete".equals(action))
		{
			int id = Integer.parseInt(request.getParameter("Id"));
			if (ManagerDAO.ManagerDetele(id))
			{
				request.setAttribute("message", "用户删除成功！");
			}
			else
			{
				request.setAttribute("message", "用户删除失败！");
			}
			disPatcher(request, response);

		}
		
		//查看所有
		else if ("getAll".equals(action))
		{
			disPatcher(request, response);
		}
		
		//登出
		else if ("loginOut".equals(action))
		{
			request.getSession().removeAttribute("manager");
			out.print("<script>parent.window.location.href='../index.jsp'</script>");
		}

	}

	private void disPatcher(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd;
		pageSplit(request);
		rd = request.getRequestDispatcher("/bManager/selectManager.jsp");
		rd.forward(request, response);
	}

	//分页的处理
	private void pageSplit(HttpServletRequest request)
	{
		List<Manager> managerList;
		managerList = ManagerDAO.getAllManager();
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

		Pagination<Manager> managerPage = new Pagination<Manager>();
		managerList = managerPage.splitPage(managerList, "manager", pageNumber);
		request.setAttribute("page", pageNumber);
		request.setAttribute("totalPage", managerPage.getTotalPage());

		request.setAttribute("managerList", managerList);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		doGet(request, response);
	}

}
