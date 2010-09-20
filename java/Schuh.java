public final class Schuh
{
	// Members.
	//
	private int groesse;
	private String hersteller;
	private String modellbezeichnung;
	
	// Construction.
	//
	public Schuh()
	{
		this(0, "(unbenannt)");
	}
	
	public Schuh(int groesse)
	{
		this(groesse, "(unbenannt)");
	}
	
	public Schuh(int groesse, String modellbezeichnung)
	{
		this.groesse = groesse;
		this.modellbezeichnung = modellbezeichnung;
	}
	
	// Properties.
	//
	public int getGroesse()
	{ return this.groesse; }
	
	public void setGroesse(int value)
	{ this.groesse = value; }
	
	public String getHersteller()
	{ return this.hersteller; }
	
	public void setHersteller(String value)
	{ this.hersteller = value; }
	
	public String getModellbezeichnung()
	{ return this.modellbezeichnung; }
	
	public void setModellbezeichnung(String value)
	{ this.modellbezeichnung = value; }
	
	// Methods.
	//
	public void print()
	{
		System.out.println("Grösse: " + this.groesse);
		System.out.println("Hersteller: " + this.hersteller);
		System.out.println("Modellbezeichnung: " + this.modellbezeichnung);
	}
}
