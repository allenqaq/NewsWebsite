package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import beans.Notice;

/**
 * 公告操作类
 * 
 * @project Notice
 * @author admin
 * 
 */

// 公告，主界面左侧
//公告在数据库中的操作
public class NoticeDAO
{
	/**
	 * 添加公告信息
	 * 
	 * @param notice
	 *            需要添加的公告
	 * @return 是否添加成功
	 */
	public static boolean NoticeAdd(Notice notice)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "insert into NoticeInfo (NoticeTitle,NoticeContent,CreateTime) values(?,?,?)";
		PreparedStatement ps = null;// 数据库预处理
		try
		{
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, notice.getNoticeTitle());
			ps.setString(2, notice.getNoticeContent());
			ps.setString(3, notice.getCreateTime());
			if (ps.executeUpdate() > 0)
			{
				return true;
			}

		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null); // 释放数据
		}
		return false;
	}

	/**
	 * 更新公告信息
	 * 
	 * @param notice
	 *            需要更新的公告
	 * @return 是否更新成功
	 */
	public static boolean NoticeUpdate(Notice notice)
	{

		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "update NoticeInfo set NoticeTitle=?,NoticeContent=? where NoticeId=?";
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sqlStr);// 数据库预处理
			ps.setString(1, notice.getNoticeTitle());
			ps.setString(2, notice.getNoticeContent());
			ps.setInt(3, notice.getNoticeID());
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// 释放数据
		}
		return false;
	}

	/**
	 * 删除公告信息
	 * 
	 * @param id
	 *            所需删除公告的id
	 * @return 是否删除成功
	 */
	public static boolean NoticeDelete(int id)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "delete from NoticeInfo where NoticeID =" + id;
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sqlStr);// 数据库预处理
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
			con.close();
			ps.close();
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// 释放数据
		}
		return false;

	}

	/**
	 * 根据编号获取公告信息
	 * 
	 * @param noticeId
	 *            所需获取信息公告的id
	 * @return 根据编号查询的公告的信息
	 */
	public static Notice getNoticeByID(int noticeId)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "select NoticeID,NoticeTitle,NoticeContent,CreateTime from NoticeInfo where NoticeID ="
				+ noticeId;
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);
			if (rs.next())
			{
				Notice notice = returnNotice(rs);
				return notice;
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);// 释放数据
		}
		return null;

	}

	/**
	 * 公告信息添加
	 * 
	 * @param rs
	 *            传递的结果
	 * @return 添加信息后的公告
	 * @throws SQLException
	 */
	public static Notice returnNotice(ResultSet rs) throws SQLException
	{
		Notice notice = new Notice();
		notice.setNoticeID(rs.getInt("NoticeID"));
		notice.setNoticeTitle(rs.getString("NoticeTitle"));
		notice.setNoticeContent(rs.getString("NoticeContent"));
		notice.setCreateTime(rs.getString("CreateTime"));
		return notice;
	}

	/**
	 * 获取所有新闻信息
	 * 
	 * @return 所有公告的信息
	 */
	public static ArrayList<Notice> getAllNotice()
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "select NoticeID,NoticeTitle,NoticeContent,CreateTime from NoticeInfo order by CreateTime desc";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);
			ArrayList<Notice> noticeList = new ArrayList<Notice>();
			while (rs.next())
			{
				Notice notice = returnNotice(rs);
				noticeList.add(notice);
			}
			return noticeList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);// 释放数据
		}

		return null;
	}

	public static void main(String[] args) throws SQLException
	{
		/*
		 * 测试 Notice n = new Notice(); n.setNoticeTitle("就点！！紧的");
		 * n.setNoticeContent("！！机"); SimpleDateFormat timeFormat=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time
		 * =timeFormat.format(new java.util.Date()); n.setCreateTime(time);
		 * if(NoticeDAO.NoticeAdd(n)){ System.out.println("公告信息添加成功！"); }else{
		 * System.out.println("公告信息添加失败！"); }
		 */

		// n.setNoticeTitle("接口即可看见了");
		// if(NoticeDAO.NoticeUpdate(n)){
		// System.out.println("公告信息更新成功！");
		// }else{
		// System.out.println("公告信息更新失败！");
		// }

		// if(NoticeDAO.NoticeDelete(2)){
		// System.out.println("公告信息删除成功！");
		// }else{
		// System.out.println("公告信息删除失败！");
		// }

		// Notice n= NoticeDAO.getNoticeByID(1);
		// System.out.println(n.getNoticeID()+"\t"+n.getNoticeTitle()+"\t"+n.getNoticeContent()+"\t"+n.getCreateTime());
		ArrayList<Notice> nl = NoticeDAO.getAllNotice();
		for (Notice notice : nl)
		{
			System.out
					.println(notice.getNoticeID() + "\t"
							+ notice.getNoticeTitle() + "\t"
							+ notice.getNoticeContent() + "\t"
							+ notice.getCreateTime());

		}
	}

}
