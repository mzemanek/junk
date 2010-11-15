// 2010-11-15
// package Polymorphic;

import java.lang.Math;

public final class Kreis extends BasisKlasse
{
	// Members.
	//
	private double radius;
	
	// Construction.
	//
	public Kreis(double radius)
	{
		this.radius = radius;
	}
	
	// Methods.
	//
	protected double berechneFlaeche()
	{
		return Math.PI * this.radius * this.radius;
	}
	
	protected double berechneUmfang()
	{
		return 2.0d * Math.PI * this.radius;
	}
	
	protected void printBaseUnit()
	{
		System.out.println("Der Radius beträgt: " + this.radius);
	}
}
