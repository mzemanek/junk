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
		this(fix, 0.0d, 0);
	}
	
	public Kosten(double fix, double variabel, int stueckzahl)
	{
		this.fix = fix;
		this.stueckzahl = stueckzahl;
		this.variabel = variabel;
	}
	
	// Properties.
	//
	public double getFix() { return this.fix; }
	public double getGesamt() { return this.fix + (this.variabel * this.stueckzahl); }
	public double getStueckzahl() { return this.stueckzahl; }
	public double getVariabel() { return this.variabel; }
	
	// Methods.
	//
	public String toString()
	{
		return "Kosten: " + new Double(this.getGesamt()).toString();
	}
}