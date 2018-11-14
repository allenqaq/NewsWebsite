package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.Manager;

//�û�����
//���ݿ����Ĳ���
//��½�ļ��
public class ManagerDAO
{
	// �û�������

	public static boolean ManagerAdd(Manager m)
	{
		// ����û�����
		Connection con = DbConnectDAO.getConnection();
		// ����һ�����ݿ����Ӷ���
		String sql = "insert into ManagerInfo (type,number,name,account,password) values(?,?,?,?,?)";
		// ���û������һ���¼�¼
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sql);
			ps.setInt(1, m.getType());
			ps.setInt(2, m.getNumber());
			ps.setString(3, m.getName());
			ps.setString(4, m.getAccount());
			ps.setString(5, m.getPassword());
			// ���ò����û������Ӧ���Ե�ֵ
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

	//����
	public static boolean ManagerUpdate(Manager m)
	{
		// �û����·���
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
			// �����û��������ֵ
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

	//ɾ��
	public static boolean ManagerDetele(int id)
	{
		// �û�ɾ��
		Connection con = DbConnectDAO.getConnection();
		String sql = "delete from ManagerInfo where ManagerId =" + id;// SQL���ɾ���û�
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

	//��id���û�
	public static Manager getManagerById(int id)
	{
		// �����û���Ų����û�
		Connection con = DbConnectDAO.getConnection();
		String sql = "select * from ManagerInfo where ManagerId =" + id;// SQL�������û�
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

	//ȡ���û��˺�
	public static Manager getManagerByAccount(String account)
	{
		// �����˺Ų����û�
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

	
	//�����û�����Ϣ
	//�Աȵ�ʱ����
	//��½ --�Ա�
	public static ArrayList<Manager> getAllManager()
	{
		// ���������û�
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
		// �����û�
		Manager m = new Manager();
		m.setAccount(rs.getString("Account"));
		m.setManagerID(rs.getInt("ManagerID"));
		m.setName(rs.getString("name"));
		m.setNumber(rs.getInt("number"));
		m.setPassword(rs.getString("password"));
		m.setType(rs.getInt("Type"));
		return m;
	}

	//��½�ļ���
	public static Manager CheckLogin(Manager m)
	{
		// ��¼����
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

	//����
	public static void main(String[] args)
	{
		// ������
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
