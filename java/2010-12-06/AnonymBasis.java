// 2010-12-06
// package anonymbasis;

public abstract class AnonymBasis
{
	public abstract int f(int a, int b);
	
	public void drucke()
	{
		System.out.println("Ergebnis von f(2,3) = " + this.f(2, 3));
	}
}
