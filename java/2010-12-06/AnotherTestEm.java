// 2010-12-15
// package fatherandson2;

public abstract class AnotherTestEm
{
	public static void main(String[] args)
	{
		FamilyGuy fg = new FamilyGuy();
		Object subject = null;
		
		System.out.println("Test mit true.");
		subject = fg.whichOne(true);
		System.out.println(subject);
		((IPrintStuff)subject).printStuff();
		
		System.out.println("Test mit false.");
		subject = fg.whichOne(false);
		System.out.println(subject);
		((IPrintStuff)subject).printStuff();
	}
}
