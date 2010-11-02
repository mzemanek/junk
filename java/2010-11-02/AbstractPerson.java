// 2010-11-02
// package Uebung;

public abstract class AbstractPerson
{
	// Members.
	//
	private String nachname = null;
	
	// Construction.
	//
	
	// Properties.
	//
	public String get_nachname() { return this.nachname; }
	public void set_nachname(String value) { this.nachname = value; }
	
	public abstract String get_vorname();
	public abstract void set_vorname(String value);
	 
	// Methods.
	//
	public String toString()
	{
		return this.get_nachname() + ", " + this.get_vorname();
	}
}
