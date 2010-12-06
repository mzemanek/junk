// 2010-12-06
// package fatherandson;

public abstract class Father
{
	public abstract String iAmFather(String input);
	
	public void print()
	{
		System.out.println("Ich bin " + this.iAmFather("Vater"));
	}
}
