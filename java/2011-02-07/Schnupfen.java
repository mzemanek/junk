// 2011-02-07
// package Abenteuerspiel;

public class Schnupfen extends Operation
{
	public Schnupfen(Spielfigur spielfigur)
	{
		super(spielfigur);
	}
	
	public void drohe()
	{
		System.out.println("*Schnief*");
		super.drohe();
	}
}
