// 2011-01-26
// package Aufgabe 19.4;

import java.io.*;

public final class Writer extends Thread
{
	private int count = 0;
	private Stack stack = null;
	
	public Writer(Stack stack, int count)
	{
		this.count = count;
		this.stack = stack;
	}
	
	public void run()
	{
		try
		{
			for (int i = 0; i < count; i++)
			{
				int value = i + 1;
				
				this.stack.push(value);
				System.out.println("Schreibe " + value);
			}
		}
		catch (java.lang.InterruptedException ex)
		{
			// Intentionally left blank.
		}
	}
}
