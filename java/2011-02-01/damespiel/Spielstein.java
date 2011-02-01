// 2011-02-01
package damespiel;

public abstract class Spielstein
{
	private String farbe = null;
	private String typ = null;
	private int rowPos = -1;
	private int colPos = -1;
	
	public String getFarbe() { return this.farbe; }
	public String getTyp() { return this.typ; }
	public int getRowPos() { return this.rowPos; }
	public int getColPos() { return this.colPos; }
	
	public void setRowPos(int value) { this.rowPos = value; }
	public void setColPos(int value) { this.colPos = value; }
}
