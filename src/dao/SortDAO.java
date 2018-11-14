package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import beans.Sort;

//对于从数据库取出的新闻进行分类
//按要求取出数据（编号，关键字）
//分类信息在数据库中的操作
public class SortDAO
{
	// 添加新闻分类
	public static boolean SortAdd(Sort sort)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		PreparedStatement ps = null;
		String sqlStr = "insert into SortInfo (SortName,CreateTime) values(?,?)";
		try
		{
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, sort.getSortName());
			ps.setString(2, sort.getCreateTime());
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
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;
	}

	// 更新新闻分类
	public static boolean SortUpdate(Sort sort)
	{

		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "update SortInfo set SortName=? where SortId=?";
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, sort.getSortName());
			ps.setInt(2, sort.getSortId());
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
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;
	}

	// 删除新闻分类
	public static boolean SortDelete(int id)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "delete from SortInfo where SortID =" + id;
		PreparedStatement ps = null;
		try
		{
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
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;

	}

	// 根据编号获取新闻分类信息
	public static Sort getSortByID(int sortId)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		try
		{
			Statement stm = con.createStatement();
			String sqlStr = "select SortID,SortName,CreateTime from SortInfo where SortID ="
					+ sortId;
			ResultSet rs = stm.executeQuery(sqlStr);
			if (rs.next())
			{
				Sort sort = returnSort(rs);
				return sort;
			}

		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// 返回
	public static Sort returnSort(ResultSet rs) throws SQLException
	{
		Sort sort = new Sort();
		sort.setSortId(rs.getInt("SortID"));
		sort.setSortName(rs.getString("SortName"));
		sort.setCreateTime(rs.getString("CreateTime"));
		return sort;
	}

	// 获取所有新闻信息
	public static ArrayList<Sort> getAllSort()
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		String sqlStr = "select SortID,SortName,CreateTime from SortInfo ";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);
			ArrayList<Sort> sortList = new ArrayList<Sort>();
			while (rs.next())
			{
				Sort sort = returnSort(rs);
				sortList.add(sort);
			}
			return sortList;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);
		}

		return null;
	}

	// 测试
	public static void main(String[] args) throws SQLException
	{
		/*
		 * Sort s = new Sort(); s.setSortID(4); SimpleDateFormat timeFormat=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time
		 * =timeFormat.format(new java.util.Date()); s.setCreateTime(time);
		 */

		/*
		 * if(SortDAO.SortAdd(s)){ System.out.println("新闻分类添加成功！"); }else{
		 * System.out.println("新闻分类添加失败！"); }
		 */
		/*
		 * s.setSortName("接口即可看见了"); if(SortDAO.SortUpdate(s)){
		 * System.out.println("新闻分类更新成功！"); }else{
		 * System.out.println("新闻分类更新失败！"); }
		 */

		/*
		 * if(SortDAO.SortDelete(3)){ System.out.println("新闻分类删除成功！"); }else{
		 * System.out.println("新闻分类删除失败！"); }
		 */

		Sort s = SortDAO.getSortByID(1);
		System.out.println(s.getSortId() + "\t" + s.getSortName() + "\t"
				+ s.getCreateTime());
		ArrayList<Sort> sl = SortDAO.getAllSort();
		for (Sort sort : sl)
		{
			System.out.println(sort.getSortId() + "\t" + sort.getSortName()
					+ "\t" + sort.getCreateTime());

		}
	}

}
