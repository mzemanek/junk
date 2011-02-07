// 2011-02-01
package Spielesammlung;

public class Spieler
{
	private Spiel spiel = null;
	
	public Spieler(Spiel spiel)
	{
		this.spiel = spiel;
	}
	
	public boolean play()
	{
		return this.spiel.run();
	}
}
