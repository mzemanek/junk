package finance.and.investment;

public class Kosten
{
	// Members.
	//
	private double kostenFix = 0.0d;
	private double kostenVariabel = 0.0d;
	private int stueckzahl = 0;
	
	// Construction/Destruction.
	//
	
	// Properties.
	//
	
	// Methods.
	//
	public double getGesamtkosten()
	{
		return this.kostenFix + this.kostenVariabel * this.stueckzahl;
	}
	
	public void print(String prefix)
	{
		if (null == prefix)
		{
			prefix = "";
		}
		
		System.out.printf("%s  Stueckzahl:\t%i\n", prefix, this.stueckzahl);
		System.out.printf("%s* Variable Kosten:\t%d\n", prefix, this.kostenVariabel);
		System.out.printf("%s-------------------------------------\n", prefix);
		System.out.printf("%s\t\t\t%d\n", prefix, this.kostenVariabel * this.stueckzahl);
		
	}
}
