// package Kurs;

public final class Teilnehmer
{
	// Members.
	//
	private String name;
	
	// Construction.
	//
	public Teilnehmer(String name)
	{
		this.set_name(name);
	}
	
	// Properties.
	//
	public String get_name()
	{ return this.name; }
	
	public void set_name(String value)
	{ this.name = value; }
	
	// Methods.
	//
	public String toString()
	{
		return this.get_name();
	}
}
