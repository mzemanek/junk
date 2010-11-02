// 2010-11-02
// package Uebung;

public final class Kurs
{
	// Members.
	//
	private Mitarbeiter dozent = null;
	private String name = null;
	private Student[] teilnehmer = null;
	
	// Construction.
	//
	public Kurs(String name, Mitarbeiter dozent, Student[] teilnehmer)
	{
		// Initialize members.
		this.set_dozent(dozent);
		this.set_name(name);
		this.set_teilnehmer(teilnehmer);
	}
	
	public Kurs(String name, Mitarbeiter dozent)
	{
		this(name, dozent, null);
	}
	
	public Kurs(String name)
	{
		this(name, null, null);
	}
	
	// Properties.
	//
	public Mitarbeiter get_dozent() { return this.dozent; }
	public void set_dozent(Mitarbeiter value) { this.dozent = value; }

	public String get_name() { return this.name; }
	public void set_name(String value) { this.name = value; }
		
	public Student[] get_teilnehmer() { return this.teilnehmer; }
	public void set_teilnehmer(Student[] value) { this.teilnehmer = value; }
	
	// Methods.
	//
	public void print()
	{
		System.out.printf("Kurs:\t%s\n", this.get_name());
		System.out.printf("Dozent:\t%s\n", this.get_dozent());
		if (null == this.get_teilnehmer())
		{
			System.out.println("Keine Teilnehmer.");
		}
		else
		{
			System.out.println("Teilnehmer:");
			for (int i = 0; i < this.get_teilnehmer().length; i++)
			{
				Student teilnehmer = this.get_teilnehmer()[i];
				
				System.out.println(teilnehmer);
				if (null != teilnehmer.get_bankverbindung())
				{
					System.out.println(teilnehmer.get_bankverbindung());
				}
				else
				{
					System.out.println("Keine Bankverbindung angegeben");
				}
			}
		}
		
		System.out.println();
	}
	
	public String toString()
	{
		int teilnehmerzahl = 0;
		
		if (null != this.get_teilnehmer())
		{
			teilnehmerzahl = this.get_teilnehmer().length;
		}
		
		return this.get_name() + " (" + this.dozent + "; " + teilnehmerzahl + " Teilnehmer)"; 
	}
}
