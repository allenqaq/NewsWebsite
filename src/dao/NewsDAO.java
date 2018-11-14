package dao;

import java.sql.*;
import java.util.ArrayList;

import beans.News;

//新闻在数据库中的操作
public class NewsDAO
{
	// 添加新闻
	public static boolean NewsAdd(News news)
	{
		// 获取数据库连接对象
		Connection con = DbConnectDAO.getConnection();
		// 向表NewsInfo插入一条News类型的news
		String sqlStr = "insert into NewsInfo (SortId,NewsTitle,NewsContent,CreateTime) values(?,?,?,?)";
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sqlStr);
			ps.setInt(1, news.getSortId());
			ps.setString(2, news.getNewsTitle());
			ps.setString(3, news.getNewsContent());
			ps.setString(4, news.getCreateTime());
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

	// 更新新闻
	public static boolean NewsUpdate(News news)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 更新表NewsInfo的NewsID为news.NewsID的记录
		String sqlStr = "update NewsInfo set SortID=?,NewsTitle=?,NewsContent=? where NewsID=?";
		PreparedStatement ps = null;
		try
		{
			ps = con.prepareStatement(sqlStr);
			ps.setInt(1, news.getSortId());
			ps.setString(2, news.getNewsTitle());
			ps.setString(3, news.getNewsContent());
			ps.setInt(4, news.getNewsID());
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

	// 删除新闻
	public static boolean deleteNews(int newsId)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 删除表NewsInfo中NewsID是newsId的记录
		String sqlStr = "delete from NewsInfo where NewsID =" + newsId;
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

	// 根据新闻编号获取新闻信息
	public static News getNewsByID(int newsId)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象

		Statement stm;
		try
		{
			stm = con.createStatement();
			// 查找表NewsInfo中NewsId是newsId的新闻
			String sqlStr = "select NewsID,SortID,NewsTitle,NewsContent,CreateTime from NewsInfo where NewsId ="
					+ newsId;
			ResultSet rs = stm.executeQuery(sqlStr);
			if (rs.next())
			{
				News news = returnNews(rs);
				return news;
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 获取所有新闻信息
	public static ArrayList<News> getAllNews()
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 查找表NewsInfo中的所有记录
		String sqlStr = "select NewsID,NewsInfo.SortID,NewsTitle,NewsContent,NewsInfo.CreateTime from NewsInfo,SortInfo  where NewsInfo.SortID=SortInfo.SortID  order by CreateTime desc";
		return returnNewsList(con, sqlStr);
	}

	// 根据新闻标题查看新闻信息
	public static ArrayList<News> getNewsByNewsTitle(String title)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 查找表NewsInfo中标题中含有title的记录
		String sqlStr = "select NewsID,SortID,NewsTitle,NewsContent,CreateTime from NewsInfo where NewsTitle like '%"
				+ title + "%'  order by CreateTime desc";
		return returnNewsList(con, sqlStr);
	}

	// LIST 用于暂时存储
	public static ArrayList<News> returnNewsList(Connection con, String sqlStr)
	{
		Statement stm = null;
		ResultSet rs = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(sqlStr);

			ArrayList<News> newsList = new ArrayList<News>();
			// 存数据
			while (rs.next())
			{
				News news = returnNews(rs);
				newsList.add(news);
			}
			return newsList;
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

	// 新闻纪录
	public static News returnNews(ResultSet rs) throws SQLException
	{
		News news = new News();
		news.setNewsID(rs.getInt("NewsID"));
		news.setSortId(rs.getInt("SortID"));
		news.setNewsTitle(rs.getString("NewsTitle"));
		news.setNewsContent(rs.getString("NewsContent"));
		news.setCreateTime(rs.getString("CreateTime"));
		return news;
	}

	// 根据分类编号查看新闻信息
	public static ArrayList<News> getNewsBySortID(int sortID)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 查看NewsInfo中分类为sortID的新闻
		String sqlStr = "select NewsID,SortID,NewsTitle,NewsContent,CreateTime from NewsInfo where SortID ="
				+ sortID + " order by CreateTime desc";
		return returnNewsList(con, sqlStr);
	}

	// 根据新闻标题和分类编号查看新闻信息
	public static ArrayList<News> getNewsByNewsTitleandSortID(String newsTitle,
			int sortID)
	{
		Connection con = DbConnectDAO.getConnection();// 获取数据库连接对象
		// 查看表NewsInfo中分类为sortID下的包含newsTitle标题的新闻
		String sqlStr = "select NewsID,SortID,NewsTitle,NewsContent,CreateTime from NewsInfo where 1=1";
		if (null != newsTitle && !("".equals(newsTitle)))
		{
			sqlStr += " and NewsTitle like '%" + newsTitle
					+ "%' or NewsContent like '%" + newsTitle + "%'";

		}
		if (sortID != 0)
		{
			sqlStr += "  and SortID =" + sortID;

		}

		sqlStr += " order by CreateTime desc ";
		return returnNewsList(con, sqlStr);
	}

	// 测试
	public static void main(String[] args) throws SQLException
	{
		ArrayList<News> nl = NewsDAO.getAllNews();
		System.out.println(nl.size());
		/*
		 * for (News news : nl) {
		 * System.out.println(news.getNewsID()+"\t"+news.getSortId
		 * ()+"\t"+news.getNewsTitle
		 * ()+"\t"+news.getNewsContent()+"\t"+news.getCreateTime());
		 * 
		 * }
		 */

	}

}
