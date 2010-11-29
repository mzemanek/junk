// 2010-11-29
// package collection;

public class simpleVector implements collection
{
	private static final int FillFactor = 10;
	
	private int count;
	private int current;
	private Object[] items;
	
	public simpleVector()
	{
		this.items = new Object[simpleVector.FillFactor];
		this.count = -1;
		this.current = -1;
	}
	
	public void add(Object item)
	{
		this.count++;
		if (!(this.items.length > this.count))
		{
			this.extend(simpleVector.FillFactor);
		}
		
		this.items[this.count] = item;
	}
	
	public boolean contains(Object item)
	{
		for (Object other : this.items)
		{
			if (other.equals(item))
			{
				return true;	
			}
		}
		
		return false;
	}
	
	public Object next()
	{
		this.current++;
		if (current > this.count)
		{
			return null;
		}
		
		return this.items[this.current];
	}
	
	public boolean remove(Object item)
	{
		boolean found = false;
		
		for (int i = 0; i <= this.count; i++)
		{
			if (!found)
			{
				found = this.items[i].equals(item);
			}
			
			if (found)
			{
				if (i < this.count)
				{
					this.items[i] = this.items[i + 1];
				}
				else
				{
					this.items[i] = null;
				}
			}
		}
		
		if (found)
		{
			count--;
		}
		
		return found;
	}
	
	public void reset()
	{
		this.current = -1;
	}
	
	protected void extend(int factor)
	{
		Object[] extended = new Object[this.items.length + factor];
		
		for (int i = 0; i < this.items.length; i++)
		{
			extended[i] = this.items[i];
			this.items[i] = null;
		}
		
		this.items = extended;
	}
}
