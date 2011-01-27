package finance.and.investment;

public class Kosten
{
	// Members.
	//
	private double fix = 0.0d;
	private int stueckzahl = 0;
	private double variabel = 0.0d;
	
	// Construction/Destruction.
	//
	public Kosten(double fix)
	{
		this(fix, 0, 0.0d);
	}
	
	public Kosten(double fix, int stueckzahl, double variabel)
	{
		this.fix = fix;
		this.variabel = variabel;
		this.stueckzahl = stueckzahl;
	}
	
	// Properties.
	//

	// Methods.
	//
	public double getGesamtkosten()
	{
		return this.kostenFix + (this.kostenVariabel * this.stueckzahl);
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
	
	public String toString()
	{
		StringBuffer buffer = null;
		
		buffer = new StringBuffer();
		
	}
}
