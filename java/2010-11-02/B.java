// 2010-11-02
// package ABC;

public final class B
{
	private A a = null;
	private C c = null;
	
	public B(A a)
	{
		this.a = a;
		this.c = new C(this);
	}
		
	public void doIt()
	{
		System.out.println("doIt() in " + this + ", coming from " + this.a);
		this.c.doIt();
		this.a.didIt();
	}
	
	public void didIt()
	{
		System.out.println(".didIt() in " + this + ", going to " + this.a);
	}
}
