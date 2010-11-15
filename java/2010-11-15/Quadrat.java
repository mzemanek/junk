// 2010-11-15
// package Polymorphic;

public final class Quadrat extends BasisKlasse
{
	private double kantenlaenge;
	
	public Quadrat(double kantenlaenge)
	{
		this.kantenlaenge = kantenlaenge;
	}
	
	protected double berechneFlaeche()
	{
		return this.kantenlaenge * this.kantenlaenge;
	}
	
	protected double berechneUmfang()
	{
		return 4.0d * this.kantenlaenge;
	}
	
	protected void printBaseUnit()
	{
		System.out.println("Die Kantenlänge beträgt: " + this.kantenlaenge);
	}
}
