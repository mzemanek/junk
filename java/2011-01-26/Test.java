// 2011-01-26
// package Aufgabe 19.4;

public final class Test
{
	public static void main(String args[])
	{
		Reader reader = null;
		Stack stack = null;
		Writer writer = null;
		
		// Initialize scope.
		stack = new Stack(5);
		reader = new Reader(stack);
		writer = new Writer(stack, 25);
		
		reader.start();
		writer.start();
	
		// Wait for writer threads to finish.
		try
		{
			writer.join();
		}
		catch (java.lang.InterruptedException ex)
		{
			// Intentionally left blank.
		}
		
		reader.interrupt();
	}
}
