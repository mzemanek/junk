// 2010-11-02
// package ABC;

public class A
{
	private B b = null;
	
	public A()
	{
		this.b = new B(this);
	}
	
	public void doIt()
	{
		System.out.println("doIt() in " + this);
		b.doIt();
	}
	
	public void didIt()
	{
		System.out.println(".didIt() in " + this);
	}
}
