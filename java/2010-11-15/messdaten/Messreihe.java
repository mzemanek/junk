// 2010-11-15
package messdaten;

import java.util.GregorianCalendar;

public class Messreihe
{
	protected Messwert[] messwerte;
	
	public Messreihe(int messwertAnzahl)
	{
		this.messwerte = new Messwert[messwertAnzahl];
	}
	
	public void addMesswert(double messwert, GregorianCalendar datum)
	{
		int index;
		
		for (index = 0; index < this.messwerte.length; index++)
		{
			if (null == messwerte[index])
			{
				break;	
			}
		}
		
		if (index < this.messwerte.length)
		{
			this.messwerte[index] = new Messwert(messwert, datum);
		}
		else
		{
			System.out.println("Messwert konnte nicht mehr gespeichert werden.");
		}
	}
	
	public double getMesswert(GregorianCalendar datum)
	{
		for (Messwert item : this.messwerte)
		{
			if ((null != item) && item.getMessDatum().equals(datum))
			{
				return item.getWert();
			}
		}
		
		return 0.0d;
	}
	
	public void print()
	{
		for (Messwert item : this.messwerte)
		{
			if (null != item)
			{
				System.out.println(item.getMessDatum() + ": " + item.getWert());
			}
		}
	}
}
