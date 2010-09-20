public final class Punkt2
{
	// Members.
	//
	int x;
	int y;
	
	// Construction.
	//
	public Punkt2()
	{
		// Nothing to do.
	}
	
	public Punkt2(int x)
	{
		System.out.println("Konstruktor mit einem Parameter.");
		this.x = x;
	}
	
	public Punkt2(int x, int y)
	{
		System.out.println("Konstruktor mit zwei Parametern.");
		this.x = x;
		this.y = y;
	}
	
	// Properties.
	//
	public int getX()
	{ return this.x; }
	
	public void setX(int value)
	{ this.x = value; }
	
	public int getY()
	{ return this.y; }
	
	public void setY(int value)
	{ this.y = value; }
}
