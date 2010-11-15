// 2010-11-15
package temperaturmessung;

import messdaten.Messreihe;

public class TemperaturMessreihe extends Messreihe
{
	private String temperaturEinheit;
	
	public TemperaturMessreihe(int messwertAnzahl, String temperaturEinheit)
	{
		super(messwertAnzahl);
		
		this.temperaturEinheit = temperaturEinheit;
	}
	
	public void print()
	{
		System.out.println("Verwendete Einheit: " + this.temperaturEinheit);
		super.print();
	}
	
	public static double CelsiusToFahrenheit(double celsiusTemp)
	{
		return (celsiusTemp * 9 / 5) + 32;
	}
}
