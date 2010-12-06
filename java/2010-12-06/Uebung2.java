// 2010-12-06
// package uebung2;

public class Uebung2
{
	public class Inner
	{
		public Inner()
		{
			System.out.println("Inner constructor.");
		}
	}
	
	public Uebung2()
	{
		System.out.println("Uebung2 constructor.");
	}
	
	public Uebung2.Inner CreateInner()
	{
		System.out.println("Factory call:");
		return new Inner();
	}
	
	public static void main(String[] args)
	{
		Uebung2 outer = new Uebung2();
		Uebung2.Inner inner = new Uebung2().new Inner();
		Uebung2.Inner inner2 = outer.CreateInner();
	}
}
