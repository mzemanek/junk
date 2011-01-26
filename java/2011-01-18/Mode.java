// 2011-01-26
// package finance.and.investment;

abstract class Mode
{
	private Application application;
	
	protected Mode(Application application)
	{
		this.application = application;
	}
	
	public Application getApplication()
	{
		return this.application;
	}
	
	public abstract boolean Run();
}
