// 2011-02-07
// package pattern.model-view-controller;

import java.util.Scanner;

public class WurzelView
{
	private WurzelModel model = null;
	
	public void setModel(WurzelModel value)
	{
		this.model = value;
	}
	
	public void read()
	{
		Scanner input = null;
		
		System.out.println();
		System.out.println("Wurzelberechnung");
		System.out.println("Eingabe von 0 beendet das Programm.");
		System.out.print("Bitte Zahl eingeben: ");
		input = new Scanner(System.in);
		this.model.setValue(input.nextDouble());
	}
	
	public void write()
	{
		System.out.println("Die Wurzel von " + new Double(this.model.getValue()) + " ist " + new Double(this.model.getResult()));
	}
}
