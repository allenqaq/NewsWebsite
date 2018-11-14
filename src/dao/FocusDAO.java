package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.*;
import java.util.ArrayList;

import beans.Focus;

/**
 * @project Focus 焦点操作类
 * @author admin
 * 
 */

//焦点新闻的数据库处理
public class FocusDAO
{
	/**
	 * 添加焦点导读
	 * 
	 * @param focus
	 *            需要添加的焦点
	 * @return 是都添加成功
	 */
	public static boolean FocusAdd(Focus focus)
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "insert into FocusInfo (FocusTitle,FocusContent,CreateTime) values(?,?,?)";
		PreparedStatement ps = null;
		try
		{
			// 数据库预处理
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, focus.getFocusTitle());
			ps.setString(2, focus.getFocusContent());
			ps.setString(3, focus.getCreateTime());
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		// 异常处理
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		// 关闭数据库
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// 释放数据
		}
		return false;
	}

	/**
	 * 焦点更新
	 * 
	 * @param focus
	 *            需要更新的焦点
	 * @return 是否更新成功
	 */
	public static boolean FocusUpdate(Focus focus)
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "update FocusInfo set FocusTitle=?,FocusContent=? where FocusId=?";
		PreparedStatement ps = null;
		try
		{
			// 数据库预处理
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, focus.getFocusTitle());
			ps.setString(2, focus.getFocusContent());
			ps.setInt(3, focus.getFocusID());
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		// 关闭数据库
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// 释放数据
		}
		return false;
	}

	/**
	 * 焦点删除
	 * 
	 * @param id
	 *            需要删除的焦点id
	 * @return 是否删除成功
	 */
	public static boolean FocusDelete(int id)
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "delete from FocusInfo where FocusID =" + id;
		PreparedStatement ps = null;
		try
		{
			// 数据库预处理
			ps = con.prepareStatement(sqlStr);
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
	 * 根据编号获取焦点导读信息
	 * 
	 * @param focusId
	 *            需要获取信息的焦点id
	 * @return 查询的焦点
	 */
	public static Focus getFocusByID(int focusId)
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			// 处理数据
			stm = con.createStatement();
			String sqlStr = "select FocusID,FocusTitle,FocusContent,CreateTime from FocusInfo where FocusID ="
					+ focusId;
			rs = stm.executeQuery(sqlStr);
			if (rs.next())
			{
				Focus focus = returnFocus(rs);

				return focus;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 关闭数据库
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);// 释放数据
		}
		return null;

	}

	/**
	 * 获取所有新闻信息
	 * 
	 * @return 全部焦点的数组
	 */
	public static ArrayList<Focus> getAllFocus()
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "select FocusID,FocusTitle,FocusContent,CreateTime from FocusInfo order by CreateTime desc";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			// 处理数据
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);
			ArrayList<Focus> focusList = new ArrayList<Focus>();
			while (rs.next())
			{
				Focus focus = returnFocus(rs);
				focusList.add(focus);
			}
			// 关闭
			con.close();
			rs.close();
			stm.close();
			return focusList;
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

	/**
	 * 焦点的内容添加
	 * 
	 * @param rs
	 *            需要添加内容的焦点
	 * @return 添加内容后的焦点
	 * @throws SQLException
	 */
	public static Focus returnFocus(ResultSet rs) throws SQLException
	{
		Focus focus = new Focus();
		focus.setFocusID(rs.getInt("FocusID"));
		focus.setFocusTitle(rs.getString("FocusTitle"));
		focus.setFocusContent(rs.getString("FocusContent"));
		focus.setCreateTime(rs.getString("CreateTime"));
		return focus;
	}

	public static void main(String[] args)
	{
		/*
		 * //测试语句 Focus f = new Focus(); f.setFocusTitle("！！！！");
		 * f.setFocusContent("！！！！！！！"); SimpleDateFormat timeFormat=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time
		 * =timeFormat.format(new java.util.Date()); f.setCreateTime(time);
		 * if(FocusDAO.FocusAdd(f)){ System.out.println("焦点导读添加成功！"); }else{
		 * System.out.println("焦点导读添加失败！"); } f.setFocusTitle("接口即可看见了");
		 * if(FocusDAO.FocusUpdate(f)){ System.out.println("焦点导读更新成功！"); }else{
		 * System.out.println("焦点导读更新失败！"); }
		 * 
		 * if(FocusDAO.FocusDelete(2)){ System.out.println("焦点导读删除成功！"); }else{
		 * System.out.println("焦点导读删除失败！"); }
		 */
		// Focus f = FocusDAO.getFocusByID(1);
		// System.out.println(f.getFocusID()+"\t"+f.getFocusTitle()+"\t"+f.getFocusContent()+"\t"+f.getCreateTime());
		ArrayList<Focus> nl = FocusDAO.getAllFocus();
		for (Focus focus : nl)
		{
			System.out.println(focus.getFocusID() + "\t"
					+ focus.getFocusTitle() + "\t" + focus.getFocusContent()
					+ "\t" + focus.getCreateTime());

		}
	}

}
