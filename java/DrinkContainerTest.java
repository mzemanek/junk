public abstract class DrinkContainerTest
{
	public static void main(String[] args)
	{
		DrinkContainer dc1 = new DrinkContainer();
		DrinkContainer dc2 = new DrinkContainer(1000, "Masskrug");
		
		System.out.println("\nTestfall 1:");
		dc1.dump();
		
		System.out.println("\nTestfall 2:");
		dc2.dump();
	}
}
