// 2011-01-26
// package finance.and.investment;

import java.io.*;
import finance.and.investment.*;

final class Kostenvergleich extends Mode
{
	public Kostenvergleich(Application application)
	{
		super(application);
	}
	
	public boolean Run()
	{
		Investition investition = null;
		
		System.out.println();
		System.out.println();
		System.out.println("Kostenvergleichsrechnung");
		
		investition = this.ReadInvestition();
		
		System.out.println();
		System.out.println("Dump");
		System.out.println(investition);
		
		
		return false;
	}
	
	private Investition ReadInvestition()
	{
		String betrag = null;
		String nutzungsdauer = null;
		String restwert = null;
		
		System.out.println();
		System.out.println("Investition eingeben");
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.print("> Betrag:\t\t");
			betrag = r.readLine();
		
			System.out.print("> Nutzungsdauer:\t");
			nutzungsdauer = r.readLine();
		
			System.out.print("> Restwert:\t");
			restwert = r.readLine();
		}
		catch (java.io.IOException ex)
		{
			System.out.println(ex);
		}
				
		return new Investition(betrag, nutzungsdauer, restwert);
	}
}
