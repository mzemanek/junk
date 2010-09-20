//package Taschenrechner3;

public abstract class Taschenrechner3Test
{
	public static void main(String[] args)
	{
		Taschenrechner3 t = new Taschenrechner3();
		
		System.out.println("Summe:\t\t " + t.add());
		System.out.println("Differenz:\t" + t.subtract());
		System.out.println("Produkt:\t" + t.multiply());
		System.out.println("???\t\t" + t.divide());
	}
}
