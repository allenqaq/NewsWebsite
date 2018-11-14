package dao;

import java.sql.*;

//数据库连接
public class DbConnectDAO
{
	// 与数据库的连接
	public static Connection getConnection()
	{
		try
		{
			// J加载名字为 com.mysql.jdbc.Driver的Driver类。
			Class.forName("com.mysql.jdbc.Driver");
			
			// 从DriverManager取得连接
			// 连接 db_20122268数据库
			// 设置Unicode = true
			// 数据库管理 账号 密码 都是 root
			// 设置 UTF8
			//端口是 3306
			String url = "jdbc:mysql://localhost:3306/db_20122268?"
					+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			Connection con = DriverManager.getConnection(url);

			// 判断con 不为空
			if (con != null)
			{
				return con;
			}

		}

		// 异常处理
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		return null;

	}

	// 关闭与数据库的连接
	public static void freeConnection(Connection con, Statement s, ResultSet rs)
	{

		try
		{
			// 判断 con的状态
			if (null != rs)
			{
				con.close();
			}
			if (null != s)
			{
				con.close();
			}
			if (null != con)
			{
				con.close();
			}
		}
		// 异常处理
		catch (SQLException e)
		{
			e.printStackTrace();

		}

	}

}
