package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Manager;

//用户管理
//数据库层面的操作
//登陆的检查
public class ManagerDAO
{
	// 用户管理类

	public static boolean ManagerAdd(Manager m)
	{
		// 添加用户方法
		Connection con = DbConnectDAO.getConnection();
		// 创建一个数据库连接对象
		String sql = "insert into ManagerInfo (type,number,name,account,password) values(?,?,?,?,?)";
		// 在用户表插入一个新纪录
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, m.getType());
			ps.setInt(2, m.getNumber());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAccount());
			ps.setString(5, m.getPassword());
			// 设置插入用户表各对应属性的值
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;
	}

	//更新
	public static boolean ManagerUpdate(Manager m)
	{
		// 用户更新方法
		Connection con = DbConnectDAO.getConnection();
		String sql = "update ManagerInfo set `type` = ?,number = ?,name = ?,account = ?,password = ? where ManagerID = ?";
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, m.getType());
			ps.setInt(2, m.getNumber());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAccount());
			ps.setString(5, m.getPassword());
			ps.setInt(6, m.getManagerID());
			// 更新用户表各属性值
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;
	}

	//删除
	public static boolean ManagerDetele(int id)
	{
		// 用户删除
		Connection con = DbConnectDAO.getConnection();
		String sql = "delete from ManagerInfo where ManagerId =" + id;// SQL语句删除用户
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sql);
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);
		}
		return false;
	}

	//按id找用户
	public static Manager getManagerById(int id)
	{
		// 根据用户编号查找用户
		Connection con = DbConnectDAO.getConnection();
		String sql = "select * from ManagerInfo where ManagerId =" + id;// SQL语句查找用户
		ResultSet rs = null;
		Statement stm = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			if (rs.next())
			{
				Manager m = returnManager(rs);
				return m;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);
		}
		return null;
	}

	//取得用户账号
	public static Manager getManagerByAccount(String account)
	{
		// 根据账号查找用户
		Connection con = DbConnectDAO.getConnection();
		String sql = "select * from ManagerInfo where Account = '" + account
				+ "'";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			if (rs.next())
			{
				Manager m = returnManager(rs);
				return m;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);
		}
		return null;
	}

	
	//所有用户的信息
	//对比的时候用
	//登陆 --对比
	public static ArrayList<Manager> getAllManager()
	{
		// 查找所有用户
		Connection con = DbConnectDAO.getConnection();
		String sql = "select * from ManagerInfo";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			ArrayList<Manager> ml = new ArrayList<Manager>();
			while (rs.next())
			{
				Manager m = returnManager(rs);
				ml.add(m);
			}
			return ml;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);
		}

		return null;
	}

	private static Manager returnManager(ResultSet rs) throws SQLException
	{
		// 返回用户
		Manager m = new Manager();
		m.setAccount(rs.getString("Account"));
		m.setManagerID(rs.getInt("ManagerID"));
		m.setName(rs.getString("name"));
		m.setNumber(rs.getInt("number"));
		m.setPassword(rs.getString("password"));
		m.setType(rs.getInt("Type"));
		return m;
	}

	//登陆的检验
	public static Manager CheckLogin(Manager m)
	{
		// 登录测试
		Connection con = DbConnectDAO.getConnection();
		String sql = "select * from ManagerInfo where (name = ? or account = ? ) and password = ? ";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try
		{
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getName());
			ps.setString(2, m.getAccount());
			ps.setString(3, m.getPassword());
			rs = ps.executeQuery();

			if (rs.next())
			{
				m = returnManager(rs);
				return m;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnectDAO.freeConnection(con, ps, rs);
		}
		return null;
	}

	//测试
	public static void main(String[] args)
	{
		// 测试类
		Manager m = new Manager();
		m.setAccount("ky");
		m.setName("ky");
		m.setPassword("ky");
		m.setManagerID(8);
		/*
		 * Manager m = new Manager(); m = ManagerDAO.getManagerById(1);
		 */

		System.out.println(ManagerUpdate(m));

	}
}
