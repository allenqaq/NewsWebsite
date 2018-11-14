package util;

import java.io.IOException;
import java.util.*;

/**
 * 通用分页系统
 * 
 * @project News
 * @fileName Pagination.java
 * @author j2eefans
 * @param <T>
 */

//对于界面显示的分页。
//参考了网上的一些资料
//值得我学习
public class Pagination<T>
{

	private static Properties props = new Properties();
	private String fileName = "util/pageSplit/paginationConfig.properties";
	private Integer pageCount;
	private Integer totalCount;
	private Integer pageNumber;
	private Integer currentPageCount;
	private Integer totalPage;

	// 构造函数
	public Pagination()
	{
	}

	// 构造
	public Pagination(String fileName)
	{
		this.fileName = fileName;
	}

	// 取名称
	public String getFileName()
	{
		return fileName;
	}

	// 设置名称
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	// 总页数
	public Integer getTotalPage()
	{
		return totalPage;
	}

	public static String getProperties(String key)
	{
		return props.getProperty(key);
	}

	// 计数
	public Integer getPageCount()
	{
		return pageCount;
	}

	public Integer getTotalCount()
	{
		return totalCount;
	}

	// 当前页数
	public Integer getPageNumber()
	{
		return pageNumber;
	}

	public Integer getCurrentPageCount()
	{
		return currentPageCount;
	}

	// 具体的实现
	// 参考网上的资料
	// 调试能用
	private List<T> splitPage(List<T> list, Integer pageCount,
			Integer pageNumber)
	{
		List<T> newList = new ArrayList<T>();
		Integer listSize = Integer.valueOf(list.size());
		Integer startNumber = Integer.valueOf(0);
		Integer currentPageCount = Integer.valueOf(0);
		Integer totalPage = Integer.valueOf(0);
		if (listSize.intValue() <= 0)
			totalPage = Integer.valueOf(1);
		else if (listSize.intValue() % pageCount.intValue() == 0)
			totalPage = Integer.valueOf(listSize.intValue()
					/ pageCount.intValue());
		else
			totalPage = Integer.valueOf(listSize.intValue()
					/ pageCount.intValue() + 1);
		if (pageNumber.intValue() <= 0)
			pageNumber = Integer.valueOf(1);
		if (pageCount.intValue() <= 0)
			pageCount = Integer.valueOf(10);
		startNumber = Integer.valueOf((pageNumber.intValue() - 1)
				* pageCount.intValue());
		if (pageNumber.intValue() * pageCount.intValue() > listSize.intValue()
				&& listSize.intValue() - (pageNumber.intValue() - 1)
						* pageCount.intValue() > 0)
			currentPageCount = Integer.valueOf(pageCount.intValue()
					- (pageNumber.intValue() * pageCount.intValue() - listSize
							.intValue()));
		else if (listSize.intValue() - (pageNumber.intValue() - 1)
				* pageCount.intValue() <= 0)
		{
			if (listSize.intValue() % pageCount.intValue() == 0)
			{
				startNumber = Integer.valueOf((listSize.intValue()
						/ pageCount.intValue() - 1)
						* pageCount.intValue());
				pageNumber = Integer.valueOf(listSize.intValue()
						/ pageCount.intValue());
				currentPageCount = pageCount;
			}
			else
			{
				startNumber = Integer.valueOf((listSize.intValue() / pageCount
						.intValue()) * pageCount.intValue());
				pageNumber = Integer.valueOf(listSize.intValue()
						/ pageCount.intValue() + 1);
				currentPageCount = Integer.valueOf(listSize.intValue()
						- (listSize.intValue() / pageCount.intValue())
						* pageCount.intValue());
			}
		}
		else
		{
			currentPageCount = pageCount;
		}
		if (list.isEmpty())
			newList = null;
		else if (list.size() < pageCount.intValue())
			newList = list.subList(startNumber.intValue(), list.size());
		else
			newList = list.subList(startNumber.intValue(),
					startNumber.intValue() + currentPageCount.intValue());
		this.totalPage = totalPage;
		totalCount = listSize;
		this.pageNumber = pageNumber;
		this.currentPageCount = currentPageCount;
		this.pageCount = pageCount;
		return newList;
	}

	public List<T> splitPage(List<T> list, Integer pageNumber)
	{
		Integer pageCount = Integer.valueOf(0);
		try
		{
			props.load(getClass().getClassLoader()
					.getResourceAsStream(fileName));
			pageCount = Integer.valueOf(Integer
					.parseInt(getProperties("paginationConfig.pageCount")));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return splitPage(list, pageCount, pageNumber);
	}

	public List<T> splitPage(List<T> list, String prefixName, Integer pageNumber)
	{
		Integer pageCount = Integer.valueOf(0);
		try
		{
			props.load(getClass().getClassLoader()
					.getResourceAsStream(fileName));
			if (prefixName == null || "".equals(prefixName))
				pageCount = Integer.valueOf(Integer
						.parseInt(getProperties("paginationConfig.pageCount")));
			else
				pageCount = Integer.valueOf(Integer
						.parseInt(getProperties((new StringBuilder(String
								.valueOf(prefixName))).append(".pageCount")
								.toString())));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return splitPage(list, pageCount, pageNumber);
	}

	public List<T> splitPage(List<T> list, String prefixName,
			Integer pageNumber, String configName)
	{
		Integer pageCount = Integer.valueOf(0);
		try
		{
			if (configName == null)
				props.load(getClass().getClassLoader().getResourceAsStream(
						fileName));
			else
				props.load(getClass().getClassLoader().getResourceAsStream(
						(new StringBuilder(String.valueOf(configName))).append(
								".properties").toString()));
			if (prefixName == null || "".equals(prefixName))
				pageCount = Integer.valueOf(Integer
						.parseInt(getProperties("paginationConfig.pageCount")));
			else
				pageCount = Integer.valueOf(Integer
						.parseInt(getProperties((new StringBuilder(String
								.valueOf(prefixName))).append(".pageCount")
								.toString())));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return splitPage(list, pageCount, pageNumber);
	}
}
