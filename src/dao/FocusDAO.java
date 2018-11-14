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
 * @project Focus ���������
 * @author admin
 * 
 */

//�������ŵ����ݿ⴦��
public class FocusDAO
{
	/**
	 * ��ӽ��㵼��
	 * 
	 * @param focus
	 *            ��Ҫ��ӵĽ���
	 * @return �Ƕ���ӳɹ�
	 */
	public static boolean FocusAdd(Focus focus)
	{
		// ��ȡ���ݿ����Ӷ���
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "insert into FocusInfo (FocusTitle,FocusContent,CreateTime) values(?,?,?)";
		PreparedStatement ps = null;
		try
		{
			// ���ݿ�Ԥ����
			ps = con.prepareStatement(sqlStr);
			ps.setString(1, focus.getFocusTitle());
			ps.setString(2, focus.getFocusContent());
			ps.setString(3, focus.getCreateTime());
			if (ps.executeUpdate() > 0)
			{
				return true;
			}
		}
		// �쳣����
		catch (SQLException e)
		{
			e.printStackTrace();
		}

		// �ر����ݿ�
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// �ͷ�����
		}
		return false;
	}

	/**
	 * �������
	 * 
	 * @param focus
	 *            ��Ҫ���µĽ���
	 * @return �Ƿ���³ɹ�
	 */
	public static boolean FocusUpdate(Focus focus)
	{
		// ��ȡ���ݿ����Ӷ���
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "update FocusInfo set FocusTitle=?,FocusContent=? where FocusId=?";
		PreparedStatement ps = null;
		try
		{
			// ���ݿ�Ԥ����
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
		// �ر����ݿ�
		finally
		{
			DbConnectDAO.freeConnection(con, ps, null);// �ͷ�����
		}
		return false;
	}

	/**
	 * ����ɾ��
	 * 
	 * @param id
	 *            ��Ҫɾ���Ľ���id
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public static boolean FocusDelete(int id)
	{
		// ��ȡ���ݿ����Ӷ���
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "delete from FocusInfo where FocusID =" + id;
		PreparedStatement ps = null;
		try
		{
			// ���ݿ�Ԥ����
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
			DbConnectDAO.freeConnection(con, ps, null);// �ͷ�����
		}
		return false;

	}

	/**
	 * ���ݱ�Ż�ȡ���㵼����Ϣ
	 * 
	 * @param focusId
	 *            ��Ҫ��ȡ��Ϣ�Ľ���id
	 * @return ��ѯ�Ľ���
	 */
	public static Focus getFocusByID(int focusId)
	{
		// ��ȡ���ݿ����Ӷ���
		Connection con = DbConnectDAO.getConnection();
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			// ��������
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
		// �ر����ݿ�
		finally
		{
			DbConnectDAO.freeConnection(con, stm, rs);// �ͷ�����
		}
		return null;

	}

	/**
	 * ��ȡ����������Ϣ
	 * 
	 * @return ȫ�����������
	 */
	public static ArrayList<Focus> getAllFocus()
	{
		// ��ȡ���ݿ����Ӷ���
		Connection con = DbConnectDAO.getConnection();
		String sqlStr = "select FocusID,FocusTitle,FocusContent,CreateTime from FocusInfo order by CreateTime desc";
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			// ��������
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);
			ArrayList<Focus> focusList = new ArrayList<Focus>();
			while (rs.next())
			{
				Focus focus = returnFocus(rs);
				focusList.add(focus);
			}
			// �ر�
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
			DbConnectDAO.freeConnection(con, stm, rs);// �ͷ�����
		}

		return null;
	}

	/**
	 * ������������
	 * 
	 * @param rs
	 *            ��Ҫ������ݵĽ���
	 * @return ������ݺ�Ľ���
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
		 * //������� Focus f = new Focus(); f.setFocusTitle("��������");
		 * f.setFocusContent("��������������"); SimpleDateFormat timeFormat=new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); String time
		 * =timeFormat.format(new java.util.Date()); f.setCreateTime(time);
		 * if(FocusDAO.FocusAdd(f)){ System.out.println("���㵼����ӳɹ���"); }else{
		 * System.out.println("���㵼�����ʧ�ܣ�"); } f.setFocusTitle("�ӿڼ��ɿ�����");
		 * if(FocusDAO.FocusUpdate(f)){ System.out.println("���㵼�����³ɹ���"); }else{
		 * System.out.println("���㵼������ʧ�ܣ�"); }
		 * 
		 * if(FocusDAO.FocusDelete(2)){ System.out.println("���㵼��ɾ���ɹ���"); }else{
		 * System.out.println("���㵼��ɾ��ʧ�ܣ�"); }
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
