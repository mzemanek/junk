// 2011-01-26
// package finance.and.investment;

final class Application
{
	private Mode mode;
	
	public Application()
	{
		this.mode = new Choice(this);
	}
	
	public Mode getMode()
	{
		return this.mode;
	}
	
	public void setMode(Mode value)
	{
		this.mode = value;
	}
	
	public boolean Run()
	{
		return this.mode.Run();
	}
}
