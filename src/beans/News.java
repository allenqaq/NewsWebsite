package beans;

public class News
{
	// ���ű��,����int
	private int newsID;
	// ���ŷ����ţ�����int
	private int sortId;
	// ���ű��⣬����String
	private String newsTitle;
	// ��������,����String
	private String newsContent;
	// ���ŵĴ���ʱ��,����String
	private String createTime;

	// �õ����ű��(int)
	public int getNewsID()
	{
		return newsID;
	}

	// �������ű��(void)
	public void setNewsID(int newsID)
	{
		this.newsID = newsID;
	}

	// �õ�������(int)
	public int getSortId()
	{
		return sortId;
	}

	// �������ű��(void)
	public void setSortId(int sortId)
	{
		this.sortId = sortId;
	}

	// �õ����ű���(String )
	public String getNewsTitle()
	{
		return newsTitle;
	}

	// �������ű���(void)
	public void setNewsTitle(String newsTitle)
	{
		this.newsTitle = newsTitle;
	}

	// �õ���������(String )
	public String getNewsContent()
	{
		return newsContent;
	}

	// ������������(void)
	public void setNewsContent(String newsContent)
	{
		this.newsContent = newsContent;
	}

	// �õ����Ŵ���ʱ��(String )
	public String getCreateTime()
	{
		return createTime;
	}

	// �������Ŵ���ʱ��(void)
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
