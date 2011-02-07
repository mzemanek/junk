// 2011-02-07
// package Abenteuerspiel;

public class Husten extends Operation
{
	public Husten(Spielfigur spielfigur)
	{
		super(spielfigur);
	}
	
	public void drohe()
	{
		System.out.println("*Hust*");
		super.drohe();
	}
}
