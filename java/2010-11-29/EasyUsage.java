// 2010-11-29
// package easy;

public final class EasyUsage extends EasySetter implements EasyAccess
{
	public String getValue()
	{
		return this.value;
	}
	
	public void setValue(String value)
	{
		this.value = value;
	}
	
	public void print()
	{
		System.out.println("Value=" + value);
	}
}
