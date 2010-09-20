public class KidsDrink extends DrinkContainer
{
	// Members.
	//
	private String sFarbe;
	
	// Construction.
	//
	public KidsDrink(String farbe)
	{
		super();
		this.sFarbe = farbe;
	}
	
	// Properties.
	//
	public String getFarbe()
	{ return this.sFarbe; }
	
	public void setFarbe(String value)
	{ this.sFarbe = value; }
	
	// Methods.
	//
	public void dump()
	{
		super.dump();
		System.out.println("Farbe: " + this.sFarbe);
	}
}
