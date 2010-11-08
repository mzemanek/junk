// 2010-11-08
// package MyArrayClass;

public final class MyArrayClass
{
	private int[] data;
	
	public MyArrayClass()
	{
		this.data = new int[10];
		
		for (int i = 0; i < this.data.length; i++)
		{
			this.data[i] = -1;
		}
	}
	
	public String addInt(int n, int pos)
	{
		String result = null;
		
		if ((pos < 0) || (pos >= this.data.length))
		{
			result = "Ungültige Positionsangabe.";
		}
		else
		{	
			if (this.data[pos] != -1)
			{
				result = "Bestehender Wert wird überschrieben.";
			}
			else
			{
				result = "Neuer Wert wird gespeichert.";
			}
			
			this.data[pos] = n;
		}
		
		return result;
	}
	
	public void print()
	{
		System.out.println("Ausgabe des Feldes:");
		for (int i = 0; i < this.data.length; i++)
		{
			if (this.data[i] != -1)
			{
				System.out.println("pos=" + i + ";n=" + this.data[i]);
			}
		}
	}
	
	protected void finalize() throws Throwable
	{
		for (int i = 0; i < this.data.length; i++)
		{
			if (this.data[i] != -1)
			{
				this.data[i] = -1;
			}
		}
		
		this.print();
		
		System.out.println("Servus.");
		super.finalize();
	}
}
