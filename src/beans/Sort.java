package beans;

public class Sort
{

	private int sortId;/* ���������� */

	private String sortName;/* ������������ */

	private String createTime;/* ����ʱ������ */

	/* ��ȡ������ */
	public int getSortId()
	{
		return sortId;
	}

	// ���÷�����
	public void setSortId(int sortId)
	{
		this.sortId = sortId;
	}

	// ��ȡ��������
	public String getSortName()
	{
		return sortName;
	}

	// ���÷�������
	public void setSortName(String sortName)
	{
		this.sortName = sortName;
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
