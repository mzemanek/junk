// 2010-12-15
// package fatherandson;

public class FamilyGuy
{
	public IPrintStuff whichOne(boolean choice)
	{
		if (choice)
		{
			return new InnerFamilyGuy();
		}
		else
		{
			return new IPrintStuff()
			{
				public void printStuff()
				{
					System.out.println("printStuff() der anonymen Klasse.");
				}
			};
		}
	}
	
	public class InnerFamilyGuy implements IPrintStuff
	{
		public void printStuff()
		{
			System.out.println("printStuff() der inneren Klasse.");
		}
	}
}
