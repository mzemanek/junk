public final class IntStack
{
	// Members.
	//
	private int current;
	private int[] data;
	private int length;
	
	// Construction.
	//
	public IntStack(int length)
	{
		this.current = -1;
		this.data = new int[length];
		this.length = length;
	}
	
	// Properties.
	//
	
	// Methods.
	//
	public boolean isEmpty()
	{
		return (this.current == -1);
	}
	
	public int length()
	{
		return this.length;
	}
			
	public int peek()
	{
		return this.data[this.current];
	}
	
	public int pop()
	{
		int value;
		
		// Wert merken und aus Array löschen.
		value = this.data[this.current];
		this.data[this.current] = 0;
		//this.data[this.current] = null;
		
		// Position verschieben.
		this.current--;
		
		return value;
	}
	
	public void print()
	{
		for (int i = 0; i < this.length; i++)
		{
			System.out.printf("> %d=%d\n", i, this.data[i]);
		}
	}
	 
	public void push(int value)
	{
		this.current++;
		this.data[this.current] = value;		
	}
}
