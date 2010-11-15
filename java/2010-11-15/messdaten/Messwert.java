// 2010-11-15
package messdaten;

import java.util.GregorianCalendar;

class Messwert
{
	private static int anzahlMesswerte;
	private double wert;
	private GregorianCalendar messDatum;
	private int messwertID;
	
	Messwert(double messwert, GregorianCalendar messDatum)
	{
		this.messDatum = messDatum;
		this.wert = messwert;
	}
	
	double getWert()
	{
		return this.wert;
	}
	
	GregorianCalendar getMessDatum()
	{
		return this.messDatum;
	}
	
	int getMesswertID()
	{
		return this.messwertID;
	}
}
