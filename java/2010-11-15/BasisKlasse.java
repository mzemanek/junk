// 2010-11-15
// package Polymorphic;

public abstract class BasisKlasse
{
	// Methods.
	//
	public void print()
	{
		this.printBaseUnit();
		System.out.println("Die Fläche beträgt " + this.berechneFlaeche());
		System.out.println("Der Umfang beträgt " + this.berechneUmfang());
	}
	
	protected abstract void printBaseUnit();
	protected abstract double berechneFlaeche();
	protected abstract double berechneUmfang();
}
