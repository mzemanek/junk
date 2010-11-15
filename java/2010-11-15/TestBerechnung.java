// 2010-11-15
// package Polymorphic;

public abstract class TestBerechnung
{
	public static void main(String[] args)
	{
		BasisKlasse b = null;
		
		System.out.println("Teste Kreis:");
		b = new Kreis(1.75d);
		b.print();
		
		System.out.println();
		System.out.println("Teste Quadrat:");
		b = new Quadrat(3.5d);
		b.print();
	}
}
