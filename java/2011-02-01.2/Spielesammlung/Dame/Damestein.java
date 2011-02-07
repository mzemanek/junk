// 2011-02-01
package Spielesammlung.Dame;

import Spielesammlung.*;

public class Damestein implements Spielstein
{
	private int row = -1;
	private int col = -1;
	private Direction direction = Direction.NONE;
	private String farbe = null;
	private String typ = null;
	private Object spieler = null;
	
	public Damestein(String typ, String farbe, Object spieler, Direction direction)
	{
		this.direction = direction;
		this.farbe = farbe;
		this.spieler = spieler;
		this.typ = typ;
	}
	
	public Direction getDirection() { return this.direction; }
	
	public int getRow(){ return this.row; }
	public void setRow(int value){ this.row = value; }
	
	public int getCol(){ return this.col; }
	public void setCol(int value){ this.col = value; }
		
	public String getFarbe(){ return this.farbe; }

	public Object getSpieler(){ return this.spieler; }

	public String getTyp(){ return this.typ; }
	protected void setTyp(String value){ this.typ = value; }
	
	public enum Direction
	{
		NONE,
		BOTTOMUP,
		TOPDOWN;
	}
}
