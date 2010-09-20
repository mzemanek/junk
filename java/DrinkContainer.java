public class DrinkContainer
{
	// Members.
	//
	private int nInhalt;
	private String sName;
	
	// Construction.
	//
	public DrinkContainer()
	{
		this(250, "Tasse");
	}
	
	public DrinkContainer(int inhalt, String name)
	{
		this.nInhalt = inhalt;
		this.sName = name;
	}
	
	// Properties.
	//
	public int getInhalt()
	{ return this.nInhalt; }
	
	public void setInhalt(int value)
	{ this.nInhalt = value; }
	
	public String getName()
	{ return this.sName; }
	
	public void setName(String value)
	{ this.sName = value; }
	
	// Methods.
	//
	public void dump()
	{
		System.out.println("Inhalt: " + this.nInhalt);
		System.out.println("Name: " + this.sName);
	}
}
