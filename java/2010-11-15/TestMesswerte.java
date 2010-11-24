// 2010-11-15

import temperaturmessung.TemperaturMessreihe;
import java.util.GregorianCalendar;

public abstract class TestMesswerte
{
	public static void main(String[] args)
	{
		double fahrenheit;
		TemperaturMessreihe temperaturMessungen = new TemperaturMessreihe(5, "°C");
		
		GregorianCalendar datum1 = new GregorianCalendar(2000,5,10);
		temperaturMessungen.addMesswert(25.3, datum1);

		GregorianCalendar datum2 = new GregorianCalendar(2001,5,10);
		temperaturMessungen.addMesswert(23.0, datum2);
		
		GregorianCalendar datum3 = new GregorianCalendar(2002,5,10);
		temperaturMessungen.addMesswert(18.4, datum3);
		
		GregorianCalendar datum4 = new GregorianCalendar(2003,5,10);
		temperaturMessungen.addMesswert(26.9, datum4);
		
		GregorianCalendar datum5 = new GregorianCalendar(2004,5,10);
		temperaturMessungen.addMesswert(28.0, datum5);
		
		fahrenheit = TemperaturMessreihe.CelsiusToFahrenheit(25.0);
		System.out.println("25.0 °C entsprechen " + fahrenheit + " °F.");
		
		System.out.println();
		temperaturMessungen.print();	
	}
}
