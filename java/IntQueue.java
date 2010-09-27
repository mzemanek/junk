public final class IntQueue
{
	private int current;
	private int[] data;
		
	public IntQueue(int size)
	{
		this.current = -1;
		this.data = new int[size];
	}
	
	public void addElement(int element)
	{
		this.current++;
		this.data[current] = element;
		System.out.printf("wert %d hinzugefügt.\n", element);
	}
	
	public int getElement()
	{
		int stored = this.data[0];
		
		// Shift all remaining elements.
		for (int i = 0; i < this.current; i++)
		{
			data[i] = data[i + 1];
		}
		
		// Decrement counter.
		this.current--;
		
		return stored;
	}
	
	public int getElementCount()
	{
		return this.current + 1;
	}
	
	public void print()
	{
		for (int i = 0; i <= this.current; i++)
		{
			System.out.printf("Element %d=%d\n", i+1, this.data[i]);
		}
	}
}
