package beans;

public class Notice
{

	private int noticeID;// ������

	private String noticeTitle;// �������

	private String noticeContent;// ��������

	private String createTime;// ����ʱ��

	// ��ȡ������
	public int getNoticeID()
	{
		return noticeID;
	}

	// ���ù�����
	public void setNoticeID(int noticeID)
	{
		this.noticeID = noticeID;
	}

	// ��ȡ�������
	public String getNoticeTitle()
	{
		return noticeTitle;
	}

	// ���ù������
	public void setNoticeTitle(String noticeTitle)
	{
		this.noticeTitle = noticeTitle;
	}

	// ��ȡ��������
	public String getNoticeContent()
	{
		return noticeContent;
	}

	// ���ù�������
	public void setNoticeContent(String noticeContent)
	{
		this.noticeContent = noticeContent;
	}

	// ��ȡ����ʱ��
	public String getCreateTime()
	{
		return createTime;
	}

	// ���ô���ʱ��
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
