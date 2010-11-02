// 2010-11-02
// package ABC;

public final class C
{
	private B b = null;
	
	public C(B b)
	{
		this.b = b;
	}
	
	public void doIt()
	{
		System.out.println("doIt() in " + this + ", coming from " + this.b);
		this.b.didIt();
	}
}
