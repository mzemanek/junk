import java.util.Scanner;

public class Taschenrechner
{
	public static int Add(int a, int b)
	{
		return a + b;
	}
	
	private static int readInt()
	{
		Scanner eingabe = new Scanner(System.in);
		
		System.out.print("Zahl eingeben: ");
		return eingabe.nextInt();
	}
	
	public static void main(String[] args)
	{
		int a = readInt();
		int b = readInt();
		
		System.out.printf("Das Ergebnis von %d + %d ist %d\n", a, b, Add(a, b));
	}	
}
