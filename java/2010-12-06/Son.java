// 2010-12-06
// package fatherandson;

public class Son extends Father implements IExist
{
	private InnerObject myInnerObject;
	private IExist myExist;
	
	public Son(boolean b)
	{
		if (b)
		{
			// TODO: Redundant.
			// this.makeInnerObject();
			this.myInnerObject = new InnerObject();
			this.myInnerObject.print("Konstruktor Son mit True");
		}
		else
		{
			this.myExist = new IExist()
			{
				public void makeInnerObject()
				{
					System.out.println("Konstructor Son mit False, anonyme Klasse.");
					//myInnerObject = new InnerObject();
				}
			};
			
			this.myExist.makeInnerObject();
		}
	}
	
	public void makeInnerObject()
	{
		this.myInnerObject = new InnerObject();
		this.myInnerObject.print("Inneres Objekt erzeugt.");
	}
	
	public String iAmFather(String input)
	{
		return "der " + input;
	}
	
	public String iAmAlsoFather(String input)
	{
		Father anonym = new Father()
		{
			public String iAmFather(String input)
			{
				return "der innere " + input;
			}
		};
		
		return anonym.iAmFather(input);
	}
	
	public void danger(String input) throws SomeException
	{
		if ("danger".equals(input))
		{
			throw new SomeException("eine gefährliche Zeichenkette");
		}
		else
		{
			throw new SomeException("eine weniger gefährlichere Zeichenkette");
		}
	}
	
	private class InnerObject
	{
		public void print(String message)
		{
			System.out.println("print() aus Son.InnerObject");
			System.out.println("-> " + message);
		}
	}
}
