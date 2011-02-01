// 2011-01-26
// package Aufgabe 19.4;

import java.io.*;

public final class Reader extends Thread
{
	private Stack stack = null;
	
	public Reader(Stack stack)
	{
		this.stack = stack;
	}
	
	public void run()
	{
		try
		{
			while (true)
			{
				System.out.println("Lese " + this.stack.pop());
			}
		}
		catch (java.lang.InterruptedException ex)
		{
			// Intentionally left blank.
		}
	}
}
