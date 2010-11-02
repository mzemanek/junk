// 2010-11-02
// package Uebung;

public class Person extends AbstractPerson
{
	// Members.
	//
	private String vorname = null;
	
	// Construction.
	//
	public Person(String vorname, String nachname)
	{
		this.set_vorname(vorname);
		this.set_nachname(nachname);
	}
	
	// Properties.
	//
	public String get_vorname() { return this.vorname; }
	public void set_vorname(String value) { this.vorname = value; }
}
