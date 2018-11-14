package newsServlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Pagination;

import dao.NoticeDAO;
import beans.Notice;


//�����һЩ����
//ǰ̨����Ϸ�
//���ڹ������Ӻ��޸�
public class NoticeServlet extends HttpServlet
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
		String forward = "/bAffiche/selectAffiche.jsp";
		RequestDispatcher rd = null;
		// List<Notice> noticeList = null;
		
		//�鿴���й���
		if ("getAllNotice".equals(action))
		{
			pageSpilt(request);
		}
		
		//�鿴���ֹ���
		else if ("getNotice".equals(action))
		{
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			Notice notice = NoticeDAO.getNoticeByID(noticeId);
			request.setAttribute("notice", notice);
			forward = "/bAffiche/updateAffiche.jsp";

		}
		//��ӹ���
		else if ("add".equals(action))
		{
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Notice notice = new Notice();
			notice.setNoticeTitle(title);
			notice.setNoticeContent(content);
			SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
			String time = timeFormat.format(new java.util.Date());
			notice.setCreateTime(time);
			if (NoticeDAO.NoticeAdd(notice))
			{
				request.setAttribute("message", "������ӳɹ�");

			}
			else
			{
				request.setAttribute("message", "�����������ʧ��");

			}
			pageSpilt(request);

		}
		
		//���¹���
		else if ("update".equals(action))
		{
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			Notice notice = new Notice();
			notice.setNoticeTitle(title);
			notice.setNoticeContent(content);
			notice.setNoticeID(noticeId);
			if (NoticeDAO.NoticeUpdate(notice))
			{
				request.setAttribute("message", "�����޸ĳɹ�");

			}
			else
			{
				request.setAttribute("message", "�����޸�ʧ��");

			}
			pageSpilt(request);

		}
		
		//ɾ������
		else if ("delete".equals(action))
		{
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			if (NoticeDAO.NoticeDelete(noticeId))
			{
				request.setAttribute("message", "����ɾ���ɹ�");

			}
			else
			{
				request.setAttribute("message", "����ɾ��ʧ��");

			}
			pageSpilt(request);
		}
		
		//�鿴���������
		else if ("getDetail".equals(action))
		{
			int noticeId = Integer.parseInt(request.getParameter("noticeId"));
			Notice notice = NoticeDAO.getNoticeByID(noticeId);
			request.setAttribute("notice", notice);
			forward = "/bAffiche/selectContent.jsp";

		}
		rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);

	}

	//��ҳ�Ĵ���
	private void pageSpilt(HttpServletRequest request)
	{
		List<Notice> noticeList;
		noticeList = NoticeDAO.getAllNotice();
		System.out.println(noticeList);
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

		Pagination<Notice> noticePage = new Pagination<Notice>();
		noticeList = noticePage.splitPage(noticeList, "notice", pageNumber);
		request.setAttribute("page", pageNumber);
		request.setAttribute("totalPage", noticePage.getTotalPage());
		request.setAttribute("noticeList", noticeList);
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
