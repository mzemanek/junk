// 2011-01-26
// package Aufgabe 19.4;

import java.io.*;

public final class Writer extends Thread
{
	private Stack stack = null;
	
	public Writer(Stack stack)
	{
		this.stack = stack;
	}
	
	public void run()
	{
		try
		{
			for (int i = 0; i < 100; i++)
			{
				this.stack.push(i);
			}
		}
		catch (java.lang.InterruptedException ex)
		{
			// Intentionally left blank.
		}
	}
}
