package beans;

public class Sort
{

	private int sortId;/* 分类编号属性 */

	private String sortName;/* 分类名称属性 */

	private String createTime;/* 创建时间属性 */

	/* 获取分类编号 */
	public int getSortId()
	{
		return sortId;
	}

	// 设置分类编号
	public void setSortId(int sortId)
	{
		this.sortId = sortId;
	}

	// 获取分类名称
	public String getSortName()
	{
		return sortName;
	}

	// 设置分类名称
	public void setSortName(String sortName)
	{
		this.sortName = sortName;
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
