// 2010-11-02
// package Uebung;

public final class Mitarbeiter extends Person
{
	// Members.
	//
	private int mitarbeiternummer;
	
	// Construction.
	//
	public Mitarbeiter(String vorname, String nachname, int mitarbeiternummer)
	{
		// Initialize class.
		super(vorname, nachname);
		
		// Initialize members.
		this.set_mitarbeiternummer(mitarbeiternummer);
	}
	
	// Properties.
	//
	public int get_mitarbeiternummer() { return this.mitarbeiternummer; }
	public void set_mitarbeiternummer(int value) { this.mitarbeiternummer = value; }
	
	// Methods.
	//
	public String toString()
	{
		return "(" + this.get_mitarbeiternummer() + ") " + super.toString();
	}
}
