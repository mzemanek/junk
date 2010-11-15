// 2010-11-15
// package Produkt;

public abstract class Produkt
{
	private double breite;
	private double gewicht;
	private double hoehe;
	private double tiefe;
	private String name;
	
	protected Produkt(String name, double breite, double hoehe, double tiefe, double gewicht)
	{
		this.breite = breite;
		this.gewicht = gewicht;
		this.hoehe = hoehe;
		this.name = name;
		this.tiefe = tiefe;
	}

	public print()
	{
		System.out.println("Produkt: " + this.name);
		System.out.println("Allgemeine Eigenschaften");
		System.out.println("Hoehe: " + this.hoehe);
		System.out.println("Breite: " + this.breite);
		System.out.println("Tiefe: " + this.tiefe);
		System.out.println("Gewicht: " + this.gewicht);
	}
}
