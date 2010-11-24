// 2010-11-24
// package teilen;

public abstract class Teilen
{
	public static void main(String[] args)
	{
		int nenner = 0;
		int zaehler = 125;
		int ergebnis = 0;
		
		try
		{
			ergebnis = zaehler / nenner;
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println();
			ex.printStackTrace(System.out);
		}
		
		System.out.println("Ausserhalb des try-Blockes.");
	}
}
