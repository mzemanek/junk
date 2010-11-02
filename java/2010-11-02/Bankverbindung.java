// 2010-11-02
// package Uebung;

public final class Bankverbindung
{
	// Members.
	//
	private String bank = null;
	private String bankleitzahl = null;
	private String kontonummer = null;
	
	// Construction.
	//
	public Bankverbindung(String bank, String bankleitzahl, String kontonummer)
	{
		this.bank = bank;
		this.bankleitzahl = bankleitzahl;
		this.kontonummer = kontonummer;
	}
	
	// Properties.
	//
	public String get_bank() { return this.bank; }
	public void set_bank(String value) { this.bank = value; }
	
	public String get_bankleitzahl() { return this.bankleitzahl; }
	public void set_bankleitzahl(String value) { this.bankleitzahl = value; }
	
	public String get_kontonummer() { return this.kontonummer; }
	public void set_kontonummer(String value) { this.kontonummer = value; }
	
	// Methods.
	//
	public String toString()
	{
		return this.bank + ", BLZ " + this.bankleitzahl + ", Kto.-Nr. " + this.kontonummer;
	}
}
