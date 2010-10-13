public abstract class VarParList
{
	public static void method(String zeichen, int... zahlen)
	{
		int summe = 0;
		
		System.out.println("String=" + zeichen);
	
		for (int i = 0; i < zahlen.length; i++)
		{
			summe += zahlen[i];
		}
		
		System.out.println("Die Summe von " + zahlen.length + " Zahlen ist " + summe);
	}
	
	public static void main(String[] args)
	{
		// Test 1.
		method("Hallo Welt.");
		method("Hallo Welt.", 1, 5, 7);
		method("Nochmal hallo.", 4, 5, 6, 7, 9, 15);
	}
}
