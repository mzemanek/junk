// 2011-01-26
// package finance.and.investment;

import java.util.Scanner;

final class Choice extends Mode
{
	public Choice(Application application)
	{
		super(application);
	}
	
	public boolean Run()
	{
		int choice = 0;
		Scanner input = null;
		
		System.out.println();
		System.out.println();
		System.out.println("\t\tInvestitionsrechenverfahren");
		System.out.println();
		System.out.println("\t\tStatische Verfahren");
		System.out.println("\t\t[1]\tKostenvergleich");
		System.out.println("\t\t[2]\tGewinnvergleich");
		System.out.println("\t\t[3]\tRentabilitaet");
		System.out.println("\t\t[4]\tAmortisierung");
		System.out.println();
		System.out.println("\t\tDynamische Verfahren");
		System.out.println("\t\t[5]\tKapitalwert");
		System.out.println("\t\t[6]\tAnnuitaet");
		System.out.println("\t\t[7]\tIZF-Methode");
		System.out.println();
		System.out.println("\t\t[0]\tBeenden");
		System.out.println();
		System.out.println();
		System.out.print("Ihre Auswahl:\t ");
		
		input = new Scanner(System.in);
		choice = input.nextInt();
		switch (choice)
		{
			case 1:
				this.getApplication().setMode(new Kostenvergleich(this.getApplication()));
				return true;
		}
		
		return false;
	}
}
