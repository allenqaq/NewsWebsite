package beans;

public class Focus
{

	private int focusID;// �����id

	private String focusTitle;// �̵���Ŀ

	private String focusContent;// ��������

	private String createTime;// ����Ĵ���ʱ��

	/**
	 * 
	 * @return ����id
	 */
	public int getFocusID()
	{
		return focusID;
	}

	/**
	 * @param focusID
	 *            ����id
	 */
	public void setFocusID(int focusID)
	{
		this.focusID = focusID;
	}

	/**
	 * @return ������Ŀ
	 */
	public String getFocusTitle()
	{
		return focusTitle;
	}

	/**
	 * @param focusTitle
	 *            ���ݵĽ�����Ŀ
	 */
	public void setFocusTitle(String focusTitle)
	{
		this.focusTitle = focusTitle;
	}

	/**
	 * @return ��������
	 */
	public String getFocusContent()
	{
		return focusContent;
	}

	/**
	 * 
	 * @param focusContent
	 *            ���ݵĽ�������
	 */
	public void setFocusContent(String focusContent)
	{
		this.focusContent = focusContent;
	}

	/**
	 * 
	 * @return ����Ĵ���ʱ��
	 */
	public String getCreateTime()
	{
		return createTime;
	}

	/**
	 * 
	 * @param createTime
	 *            ���ݵĽ��㴴��ʱ��
	 */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
