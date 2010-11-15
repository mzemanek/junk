// 2010-11-15
// package Produkt;

public abstract class ProduktTest
{
	public static void main(String[] args)
	{
		Produkt p = null;
		
		System.out.println("Produkte:");
		
		p = new Kreiselpumpe();
		p.print();
		
		p = new Membranpumpe();
		p.print();
		
		p = new Auffangbecken();
		p.print();
	}
}
