import java.util.Scanner;

public class Taschenrechner1
{
	public static void main(String[] args)
	{
		int a;
		int b;
		String op;
		Scanner eingabe = new Scanner(System.in);
		
		// Zahl einlesen.
		System.out.print("Operand: ");
		a = eingabe.nextInt();
		
		// Operation einlesen.
		System.out.print("Operation: ");
		op = eingabe.next();
				
		// Zahl einlesen.
		System.out.print("Operand: ");
		b = eingabe.nextInt();
		
		// Validierung.
		if (op.equals("*"))
		{
			System.out.printf("%d * %d = %d\n", a, b, a * b);
		}
		else if (op.equals("+"))
		{
			System.out.printf("%d + %d = %d\n", a, b, a + b);
		}
		else if (op.equals("-"))
		{
			System.out.printf("%d - %d = %d\n", a, b, a - b);
		}
		else if (op.equals("/"))
		{
			// 0 abfangen
			if (b == 0)
			{
				System.out.println("Division durch Null ist nicht zulässig.");
			}
			else
			{
				System.out.printf("%d / %d = %d\n", a, b, a / b);
			}
		}
		else
		{
			System.out.println("Ungültige Eingabe(n).");
		}
	}
}
