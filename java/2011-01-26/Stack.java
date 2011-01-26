// 2011-01-26
// package Aufgabe 19.4;

public final class Stack
{
	private int index = 0;
	private int values[] = null;
	
	public Stack(int size)
	{
		this.values = new int[size];
	}
	
	public synchronized int pop() throws java.lang.InterruptedException
	{
		int value = 0;
		
		if (0 == this.index)
		{
			System.out.println("Reader muss warten.");
			this.wait();
		}
		
		value = this.values[--this.index];
		this.notify();
		
		return value;
	}
	
	public synchronized void push(int value) throws java.lang.InterruptedException
	{
		if (this.values.length == this.index)
		{
			System.out.println("Writer muss warten.");
			this.wait();
		}
		
		this.values[this.index] = value;
		this.index++;
		this.notify();
	}
}
