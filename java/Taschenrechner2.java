import java.util.Scanner;

public abstract class Taschenrechner2
{
	private static Scanner input = new Scanner(System.in);
	
	public static int add(int a, int b)
	{
		return a + b;
	}
	
	public static float divide(int a, int b)
	{
		// TODO: Divide by 0 should throw exception.
		return (float)(a / b);
	}
	
	public static int multiply(int a, int b)
	{
		return a * b;
	}
	
	public static int subtract(int a, int b)
	{
		return a - b;
	}
	
	private static Object readInput(boolean useNextInt)
	{
		if (useNextInt)
		{
			return new Integer(Taschenrechner2.input.nextInt());
		}
		else
		{
			return Taschenrechner2.input.next();
		}
	}
	
	public static void main(String[] args)
	{
		int a;
		int b;
		String op;
		
		// a, op und b einlesen.
		System.out.println("Aufgabe eingeben <Zahl> [+-/*] <Zahl>:");
		a = (Integer)Taschenrechner2.readInput(true);
		op = (String)Taschenrechner2.readInput(false);
		b = (Integer)Taschenrechner2.readInput(true);
		
		if (op.equals("+"))
		{
			System.out.printf("%d %s %d = %d\n", a, op, b, Taschenrechner2.add(a, b));
		}
		else if (op.equals("-"))
		{
			System.out.printf("%d %s %d = %d\n", a, op, b, Taschenrechner2.subtract(a, b));
		}
		else if (op.equals("/"))
		{
			if (b == 0)
			{
				System.out.println("Division durch 0 wird nicht unterstützt.");
			}
			else
			{
				System.out.printf("%d %s %d = %f\n", a, op, b, Taschenrechner2.divide(a, b));
			}
		}
		else if (op.equals("*"))
		{	
			System.out.printf("%d %s %d = %d\n", a, op, b, Taschenrechner2.multiply(a, b));
		}
		else
		{
			System.out.printf("Nicht unterstützte Operation: %d %s %d\n", a, op, b);
		}
	}	
}
