package dao;

import java.sql.*;

//���ݿ�����
public class DbConnectDAO
{
	// �����ݿ������
	public static Connection getConnection()
	{
		try
		{
			// J��������Ϊ com.mysql.jdbc.Driver��Driver�ࡣ
			Class.forName("com.mysql.jdbc.Driver");
			
			// ��DriverManagerȡ������
			// ���� db_20122268���ݿ�
			// ����Unicode = true
			// ���ݿ���� �˺� ���� ���� root
			// ���� UTF8
			//�˿��� 3306
			String url = "jdbc:mysql://localhost:3306/db_20122268?"
					+ "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
			Connection con = DriverManager.getConnection(url);

			// �ж�con ��Ϊ��
			if (con != null)
			{
				return con;
			}

		}

		// �쳣����
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

	// �ر������ݿ������
	public static void freeConnection(Connection con, Statement s, ResultSet rs)
	{

		try
		{
			// �ж� con��״̬
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
		// �쳣����
		catch (SQLException e)
		{
			e.printStackTrace();

		}

	}

}
