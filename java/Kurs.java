// package Kurs;

public final class Kurs
{
	// Application entry point.
	//
	public static void main(String[] args)
	{
		Kurs k1 = new Kurs("Der erste Kurs", false);
		Kurs k2 = new Kurs("Der zweite Kurs", true);
		Kurs k3 = new Kurs("Malen nach Zahlen", false);
		
		k1.addTeilnehmer("Max Mustermann");
		k1.addTeilnehmer("Fritz Müller");
		k1.print();
		
		Teilnehmer t1 = new Teilnehmer("Mike");
		
		k2.addTeilnehmer("Lieschen Müller");
		k2.addTeilnehmer(t1);
		k2.print();
		
		k3.addTeilnehmer("Sabine Tollhausen");
		k3.addTeilnehmer("Sepp Maier");
		k3.addTeilnehmer("Christoph Muser");
		k3.addTeilnehmer("Andreas Testperson");
		k3.addTeilnehmer("Franz Mustermann");
		k3.print();
	}
	
	// Members.
	//
	private String titel;
	private boolean kostenlos;
	private int teilnehmerAnzahl;
	private Teilnehmer[] teilnehmer;
		
	// Construction.
	//
	public Kurs(String titel, boolean kostenlos)
	{
		// Initialize members.
		this.kostenlos = kostenlos;
		this.teilnehmer = null;
		this.titel = titel;
	}
	
	// Properties.
	public boolean get_kostenlos()
	{ return this.kostenlos; }
	
	public void set_kostenlos(boolean value)
	{ this.kostenlos = value; }
	
	public int get_teilnehmerAnzahl()
	{	return (null == this.teilnehmer) ? 0 : this.teilnehmer.length; }
	
	public String get_titel()
	{ return this.titel; }
	
	public void set_titel(String value)
	{ this.titel = value; }

	// Methods.
	//
	public void addTeilnehmer(String name)
	{
		this.addTeilnehmer(new Teilnehmer(name));
	}
	
	public void addTeilnehmer(Teilnehmer t)
	{
		if (null == this.teilnehmer)
		{
			this.teilnehmer = new Teilnehmer[1];
		}
		else
		{	
			Teilnehmer[] alt = this.teilnehmer;
		
			// Bestehendes Array in neues (vergrössertes) Array umkopieren.
			this.teilnehmer = new Teilnehmer[alt.length + 1];
			for (int i = 0; i < alt.length; i++)
			{
				this.teilnehmer[i] = alt[i];
			}
		}
		
		// Neuen Teilnehmer aufnehmen.
		this.teilnehmer[this.teilnehmer.length - 1] = t; 
	}
	
	public void print()
	{
		int anzahl = this.get_teilnehmerAnzahl();
		
		System.out.println("Kursdaten:");
		System.out.print(this);
		System.out.println(":");
		if (anzahl > 0)
		{
			for (int i = 0; i < anzahl; i++)
			{
				System.out.println(this.teilnehmer[i]);
			}
		}
		
		System.out.println();
	}
	
	public String toString()
	{
		String result = "";
		
		result += this.get_titel();
		if (this.get_kostenlos())
		{
			result += " (kostenlos)";
		}
		
		result += "\n";
		result += this.get_teilnehmerAnzahl() + " Teilnehmer";
		
		return result;
	}	
}
