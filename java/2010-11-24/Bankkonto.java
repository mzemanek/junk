// 2010-11-24
// package bankkonto;

public final class Bankkonto
{
	private double kontostand;
	
	public Bankkonto()
	{
		this.kontostand = 0.0;
	}

	public double getKontostand()
	{
		return this.kontostand;
	}
	
	public void auszahlen(double betrag) throws TransaktionsException
	{
		if (betrag > this.kontostand)
		{
			throw new TransaktionsException("Eine Überziehung ist derzeit nicht möglich.");
		}
		
		this.kontostand -= betrag;
	}
		
	public void einzahlen(double betrag) throws TransaktionsException
	{
		if (0 > betrag)
		{
			throw new TransaktionsException("Einzuzahlender Betrag darf nicht kleiner 0.00 sein (" + betrag + ").");
		}
		
		this.kontostand += betrag;
	}
}
