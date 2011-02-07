// 2011-02-01
package Spielesammlung;

public interface Spielstein
{
	int getRow();
	void setRow(int value);
	
	int getCol();
	void setCol(int value);
		
	String getFarbe();
	Object getSpieler();
	String getTyp();
}
