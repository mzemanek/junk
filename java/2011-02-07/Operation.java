// 2011-02-07
// package Abenteuerspiel;

public abstract class Operation implements Spielfigur
{
	private Spielfigur spielfigur = null;
	
	protected Operation(Spielfigur spielfigur)
	{
		this.spielfigur = spielfigur;
	}
	
	public void drohe()
	{
		this.spielfigur.drohe();
	}
}
