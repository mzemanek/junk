// 2011-02-01
package damespiel;

public class Dame
{
	private Spielfeld feld = null;
	
	public Dame()
	{
		this.feld = new Damefeld();
		
		this.feld.printWholeField();
	}
}
