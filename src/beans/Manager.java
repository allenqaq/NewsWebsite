package beans;

public class Manager
{

	private int managerID;// �û����

	private int type;// �û�����

	private int number;// ��¼����

	private String name;// �û�����

	private String account;// �û��˺�

	private String password;// ��¼����

	// ��ȡ�û����
	public int getManagerID()
	{
		return managerID;
	}

	// �����û����
	public void setManagerID(int managerID)
	{
		this.managerID = managerID;
	}

	// ��ȡ�û�����
	public int getType()
	{
		return type;
	}

	// �����û�����
	public void setType(int type)
	{
		this.type = type;
	}

	// ��ȡ��¼����
	public int getNumber()
	{
		return number;
	}

	// ���õ�¼����
	public void setNumber(int number)
	{
		this.number = number;
	}

	// ��ȡ�û�����
	public String getName()
	{
		return name;
	}

	// �����û�����
	public void setName(String name)
	{
		this.name = name;
	}

	// ��ȡ�û��˺�
	public String getAccount()
	{
		return account;
	}

	// �����û��˺�
	public void setAccount(String account)
	{
		this.account = account;
	}

	// ��ȡ��¼����
	public String getPassword()
	{
		return password;
	}

	// ���õ�¼����
	public void setPassword(String password)
	{
		this.password = password;
	}

}
