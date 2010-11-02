// 2010-11-02
// package Uebung;

public final class Student extends Person
{
	// Members.
	//
	private int matrikelnummer;
	private Bankverbindung bankverbindung = null;
	
	// Construction.
	//
	public Student(String vorname, String nachname, int matrikelnummer, Bankverbindung bankverbindung)
	{
		// Initialize class.
		super(vorname, nachname);
	
		// Initialize members.
		this.set_matrikelnummer(matrikelnummer);
		this.set_bankverbindung(bankverbindung);	
	}
	
	// Properties.
	//
	public Bankverbindung get_bankverbindung() { return this.bankverbindung; }
	public void set_bankverbindung(Bankverbindung value) { this.bankverbindung = value; }
	
	public int get_matrikelnummer() { return this.matrikelnummer; }
	public void set_matrikelnummer(int value) { this.matrikelnummer = value; }
	
	// Methods.
	//
	public String toString()
	{
		return "[" + this.get_matrikelnummer() + "] " + super.toString();
	}
}
