// 2010-11-24
// package bankkonto;

public abstract class BankkontoTest
{
	public static void main(String[] args)
	{
		Bankkonto konto = new Bankkonto();
		double betrag;
		
		System.out.println("Kontostand: " + konto.getKontostand());
		
		try
		{
			betrag = 123.45;
			System.out.println();
			System.out.println("Einzahlung: " + betrag);
			konto.einzahlen(betrag);
			System.out.println("Kontostand: " + konto.getKontostand());
		}
		catch (TransaktionsException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		try
		{
			// Negative Einzahlung.
			betrag = -12.45;
			System.out.println();
			System.out.println("Einzahlung: " + betrag);
			konto.einzahlen(betrag);
			System.out.println("Kontostand: " + konto.getKontostand());
		}
		catch (TransaktionsException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
