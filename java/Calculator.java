public abstract class Calculator
{
	public static void main(String[] args)
	{
		if (args.length == 3)
		{
			try
			{
				float a = Float.parseFloat(args[0]);
				float b = Float.parseFloat(args[2]);
				float c = 0.0f;
				
				if (args[1].equals("+"))
				{
					c = a + b;
				}
				else if (args[1].equals("-"))
				{
					c = a - b;
				}
				else if (args[1].equals("*"))
				{
					c = a * b;
				}
				else if (args[1].equals("/"))
				{
					if (0.0f == b)
					{
						System.out.println("Division durch 0 ist nicht definiert.");
						return;
					}
					
					c = a / b;
				}
				else
				{
					System.out.printf("Operation \"%s\" wird nicht unterstützt.\n", args[1]);
					return;
				}
				
				System.out.printf("%5.2f %s %5.2f = %5.2f\n", a, args[1], b, c);
			}
			catch (Exception e)
			{
				System.out.println("Ungültige Eingabe(n).");	
			}
		}
		else
		{
			System.out.println("Usage info:");
			System.out.println("java Calculator <n> [+-*/] <n>");
			System.out.println();
		}
	}
}
