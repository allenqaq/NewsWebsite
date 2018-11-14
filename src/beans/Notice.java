package beans;

public class Notice
{

	private int noticeID;// 公告编号

	private String noticeTitle;// 公告标题

	private String noticeContent;// 公告内容

	private String createTime;// 创建时间

	// 获取公告编号
	public int getNoticeID()
	{
		return noticeID;
	}

	// 设置公告编号
	public void setNoticeID(int noticeID)
	{
		this.noticeID = noticeID;
	}

	// 获取公告标题
	public String getNoticeTitle()
	{
		return noticeTitle;
	}

	// 设置公告标题
	public void setNoticeTitle(String noticeTitle)
	{
		this.noticeTitle = noticeTitle;
	}

	// 获取公告内容
	public String getNoticeContent()
	{
		return noticeContent;
	}

	// 设置公告内容
	public void setNoticeContent(String noticeContent)
	{
		this.noticeContent = noticeContent;
	}

	// 获取创建时间
	public String getCreateTime()
	{
		return createTime;
	}

	// 设置创建时间
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
