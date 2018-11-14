package beans;

public class Focus
{

	private int focusID;// 焦点的id

	private String focusTitle;// 教的题目

	private String focusContent;// 焦点内容

	private String createTime;// 焦点的创建时间

	/**
	 * 
	 * @return 焦点id
	 */
	public int getFocusID()
	{
		return focusID;
	}

	/**
	 * @param focusID
	 *            焦点id
	 */
	public void setFocusID(int focusID)
	{
		this.focusID = focusID;
	}

	/**
	 * @return 焦点题目
	 */
	public String getFocusTitle()
	{
		return focusTitle;
	}

	/**
	 * @param focusTitle
	 *            传递的焦点题目
	 */
	public void setFocusTitle(String focusTitle)
	{
		this.focusTitle = focusTitle;
	}

	/**
	 * @return 焦点内容
	 */
	public String getFocusContent()
	{
		return focusContent;
	}

	/**
	 * 
	 * @param focusContent
	 *            传递的焦点内容
	 */
	public void setFocusContent(String focusContent)
	{
		this.focusContent = focusContent;
	}

	/**
	 * 
	 * @return 焦点的创建时间
	 */
	public String getCreateTime()
	{
		return createTime;
	}

	/**
	 * 
	 * @param createTime
	 *            传递的焦点创建时间
	 */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

}
