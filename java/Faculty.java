public abstract class Faculty
{
	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			try
			{
				long n = Long.parseLong(args[0]);
				
				System.out.println("Berechnung von " + n + "!");
				System.out.println("Iterativ: " + n + "!=" + facIterative(n));
				System.out.println("Rekursiv: " + n + "!=" + facRecursive(n));
				System.out.println();
			}
			catch (Exception ex)
			{
				System.out.printf("\"%s\" ist keine gültige Zahl.\n", args[0]);
			}
		}
		else
		{
			System.out.println("Usage info:");
			System.out.println("java Faculty <n>");
			System.out.println();
		}
	}
		
	private static long facIterative(long n)
	{
		long result = 1;
		
		while (n > 0)
		{
			result *= n--;
		}
		
		return result;
	}
	
	private static long facRecursive(long n)
	{
		if (n == 0)
		{
			return 1;
		}
		
		return n * facRecursive(n-1);
	}
}
