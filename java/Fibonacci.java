// package Fibonacci;

import java.util.Scanner;

public abstract class Fibonacci
{
	// Application entry point.
	//
	public static void main(String[] args)
	{
		int n = 0;
		long result = 0;

		System.out.println();		
		System.out.println("Berechnung der nten Fibonacci-Zahl.");
		
		if (0 == args.length)
		{
			Scanner input = null;
			
			input = new Scanner(System.in);
			System.out.print("Bitte n vorgeben: ");
			n = input.nextInt();
		}
		else
		{
			n = Integer.parseInt(args[0].trim());
		}
		
		System.out.printf("\nn = %d\n", n);
		System.out.printf("Iterative Berechnung: %d\n", fibonacci_iterative(n));
		System.out.printf("Rekursive Berechnung: %d\n", fibonacci_recursive(n));
		System.out.println();
	}
	
	private static long fibonacci_iterative(int n)
	{
		long[] values = null;
		
		switch (n)
		{
			case 0:
				return 0;
				
			case 1:
			case 2:
				return 1;
		}
		
		// Initialize scope.
		values = new long[n + 1];
		values[0] = 0;
		values[1] = 1;
		values[2] = 1;
		
		// Calculate rest of scope.
		if (n > 2)
		{
				for (int i = 3; i <= n; i++)
				{
					values[i] = values[i - 1] + values[i - 2];
				}
		}
		
		return values[n];
	}
	
	private static long fibonacci_recursive(int n)
	{
		switch (n)
		{
			case 0:
				return 0;
				
			case 1:
			case 2:
				return 1;
		}
		
		return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
	}
}
