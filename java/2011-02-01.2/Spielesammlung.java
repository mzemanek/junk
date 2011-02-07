// 2011-02-01
// package Spielesammlung;

import Spielesammlung.*;
import Spielesammlung.Dame.Damespiel;

public abstract class Spielesammlung
{
	public static void main(String[] args)
	{
		Spieler spieler = null;
		
		System.out.println("Spielesammlung (Dame)");
		System.out.println("Spiel wird eröffnet...");
		
		spieler = new Spieler(new Damespiel("weiss", "schwarz"));
		
		while (spieler.play());
		
		System.out.println("Spiel wird beendet.");
		System.out.println();
	}
}
