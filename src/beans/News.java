package beans;

public class News
{
	// 新闻编号,类型int
	private int newsID;
	// 新闻分类编号，类型int
	private int sortId;
	// 新闻标题，类型String
	private String newsTitle;
	// 新闻内容,类型String
	private String newsContent;
	// 新闻的创建时间,类型String
	private String createTime;

	// 得到新闻编号(int)
	public int getNewsID()
	{
		return newsID;
	}

	// 设置新闻编号(void)
	public void setNewsID(int newsID)
	{
		this.newsID = newsID;
	}

	// 得到分类编号(int)
	public int getSortId()
	{
		return sortId;
	}

	// 设置新闻编号(void)
	public void setSortId(int sortId)
	{
		this.sortId = sortId;
	}

	// 得到新闻标题(String )
	public String getNewsTitle()
	{
		return newsTitle;
	}

	// 设置新闻标题(void)
	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}

	// 得到新闻内容(String )
	public String getNewsContent()
	{
		return newsContent;
	}

	// 设置新闻内容(void)
	public void setNewsContent(String newsContent)
	{
		this.newsContent = newsContent;
	}

	// 得到新闻创建时间(String )
	public String getCreateTime()
	{
		return createTime;
	}

	// 设置新闻创建时间(void)
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
