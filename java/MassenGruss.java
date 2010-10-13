public abstract class MassenGruss
{
	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			try
			{
				int runs = Integer.parseInt(args[0]);
				
				for (int i = 0; i < runs; i++)
				{
					System.out.println("Hallo Welt.");
				} 
			}
			catch (Exception e)
			{
				System.out.printf("\"%s\" ist keine gültige Eingabe.\n", args[0]);
			}
		}
		else
		{
			System.out.println("Aufruf: java MassenGruss <n>");
		}
	}
}
