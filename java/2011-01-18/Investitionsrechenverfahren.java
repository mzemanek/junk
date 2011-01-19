// 2011-01-18
// package finance.and.investment;

import java.util.Scanner;

public final class Investitionsrechenverfahren
{
	public static void main(String[] args)
	{
		Application app = null;
		
		app = new Application();
		while (app.Run());
	}
}

final class Application
{
	private Mode mode;
	
	public Application()
	{
		this.mode = new Choice(this);
	}
	
	public Mode getMode()
	{
		return this.mode;
	}
	
	public void setMode(Mode value)
	{
		this.mode = value;
	}
	
	public boolean Run()
	{
		return this.mode.Run();
	}
}

abstract class Mode
{
	private Application application;
	
	protected Mode(Application application)
	{
		this.application = application;
	}
	
	public Application getApplication()
	{
		return this.application;
	}
	
	public abstract boolean Run();
}

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

final class Kostenvergleich extends Mode
{
	public Kostenvergleich(Application application)
	{
		super(application);
	}
	
	public boolean Run()
	{
		System.out.println();
		System.out.println();
		System.out.println("Kostenvergleichsrechnung");
		
		return false;
	}
}