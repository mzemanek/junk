//package Taschenrechner3;

import java.util.Scanner;

public final class Taschenrechner3
{
	private int a;
	private int b;
	
	public Taschenrechner3()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Erste Zahl: ");
		this.a = input.nextInt();
		
		System.out.print("Zweite Zahl: ");
		this.b = input.nextInt();
	}
	
	public int add()
	{
		return this.a + this.b;
	}
	
	public float divide()
	{
		return (float)((float)this.a / (float)this.b);
	}
	
	public int multiply()
	{
		return this.a * this.b;
	}
	
	public int subtract()
	{
		return this.a - this.b;
	}
}	
