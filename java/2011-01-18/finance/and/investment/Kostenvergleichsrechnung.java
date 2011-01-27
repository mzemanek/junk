// 2011-01-19
package finance.and.investment;

public class Kostenvergleichsrechnung
{
	private double investition = 0.0d;
	private int nutzungsdauer = 0;
	private double restwert = 0.0d;
	private double kalkulatorischerZins;
	
	// Construction/Destruction.
	//
	public Kostenvergleichsrechnung(double investition, int nutzungsdauer)
	{
		this(investition, nutzungsdauer);
	}
	
	// Properties.
	//
	public double getInvestition() { return this.investition; }
	public void setInvestition(double value) { this.investition = value; }
	
	public int getNutzungsdauer() { return this.nutzungsdauer; }
	public void setNutzungsdauer(int value) { this.nutzungsdauer = value; }
	
	public double getRestwert() { return this.restwert; }
	public void setRestwert(double value) { this.restwert = value; }
	
	// Methods.
	//
	public String toString()
	{
		return super.toString();
	}
}

/*
	Kostenvergleichsrechnung
	
	Durchschnittlich gebundenes Kapital: 0.5 * I + Rn


	Investition:	250 000.00	EUR
	Perioden:		      4		Jahre
	Restwert:		 50 000.00	EUR
	
	kalk. Zins:		     10.00	%
	kalk. Abschr.	 50 000.00 EUR
	
	Fixkosten:		 27 000.00 EUR
	variable K:		     12.60 EUR
	Stück:			 45 200.00 EUR
*/
