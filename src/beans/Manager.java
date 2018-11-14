package beans;

public class Manager
{

	private int managerID;// 用户编号

	private int type;// 用户类型

	private int number;// 登录次数

	private String name;// 用户名字

	private String account;// 用户账号

	private String password;// 登录密码

	// 获取用户编号
	public int getManagerID()
	{
		return managerID;
	}

	// 设置用户编号
	public void setManagerID(int managerID)
	{
		this.managerID = managerID;
	}

	// 获取用户类型
	public int getType()
	{
		return type;
	}

	// 设置用户类型
	public void setType(int type)
	{
		this.type = type;
	}

	// 获取登录次数
	public int getNumber()
	{
		return number;
	}

	// 设置登录次数
	public void setNumber(int number)
	{
		this.number = number;
	}

	// 获取用户名字
	public String getName()
	{
		return name;
	}

	// 设置用户名字
	public void setName(String name)
	{
		this.name = name;
	}

	// 获取用户账号
	public String getAccount()
	{
		return account;
	}

	// 设置用户账号
	public void setAccount(String account)
	{
		this.account = account;
	}

	// 获取登录密码
	public String getPassword()
	{
		return password;
	}

	// 设置登录密码
	public void setPassword(String password)
	{
		this.password = password;
	}

}
