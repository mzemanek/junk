// 2011-02-01
package Spielesammlung.Dame;

import java.io.*;
import Spielesammlung.*;

public class Damespiel implements Spiel
{
	Object black = null;
	Object current = null;
	Object white = null;
	Spielfeld spielfeld = null;
	Spielstein[] spielsteine = null;
	String message = null;
	
	public Damespiel(Object white, Object black)
	{
		int row = 0;
		int col = 0;
		
		this.black = black;
		this.white = white;
		
		this.spielfeld = new Damefeld();
		this.spielsteine = new Spielstein[16];
		
		// Create and place tokens for black.
		for (int i = 0; i < 8; i++)
		{
			row = (i < 4) ? 0 : 1;
			col = (2 * i) - (row * 7);
			
			this.spielsteine[i] = new Damestein("Bauer", "S", this.black, Damestein.Direction.TOPDOWN);
			this.spielfeld.moveToken(this.spielsteine[i], row, col);
		}
	
		// Create and place tokens for white.
		for (int i = 0; i < 8; i++)
		{
			row = (i < 4) ? 6 : 7;
			col = (2 * i) + 1 - ((row - 6) * (7 + 2));
			this.spielsteine[8 + i] = new Damestein("Bauer", "O", this.white, Damestein.Direction.BOTTOMUP);
			this.spielfeld.moveToken(this.spielsteine[8 + i], row, col);
		}
		
		// Weiss beginnt.
		this.current = this.white;
	}
	
	public boolean run()
	{
		// Render current state.
		this.render();
		
		// Query player.
		try
		{
			return this.turn();
		}
		catch (IOException ex)
		{
			System.out.println(ex);
		}
		
		return false;
	}
	
	private void render()
	{
		System.out.println();
		this.spielfeld.printWholeField();
		System.out.println();
	}
	
	private boolean turn() throws java.io.IOException
	{
		String input = null;
		
		if (null != this.message)
		{
			System.out.println(this.message);
			this.message = null;
		}
		
		System.out.printf("Bitte Zug eingeben (%s): ", this.current);
		input = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();
		if (input.equals("EXIT"))
		{
			return false;
		}
		
		// Parse input and adjust state.
		System.out.println("Input:" + input);
		if (!input.matches("[A-H][1-8]\\s[A-H][1-8]"))
		{
			this.message = "Ungueltige Eingabe. Erlaubt sind \"[A-H][1-8] [A-H][1-8]\" oder \"exit\"";
		}
		else
		{
			Damestein stein = null;
			char[] chars = null;
			int r1 = 0;
			int c1 = 0;
			int r2 = 0;
			int c2 = 0;
			
			chars = input.toCharArray();
			r1 = (int)chars[0] - 65;
			c1 = (int)chars[1] - 49;
			r2 = (int)chars[3] - 65;
			c2 = (int)chars[4] - 49;
			
			System.out.println("r1=" + r1 + ";c1=" + c1 + ";r2=" + r2 + ";c2=" + c2);
			
			// Get token.
			stein = (Damestein)this.spielfeld.getToken(r1, c1);
			if (null == stein)
			{
				this.message = "Feld " + chars[0] + chars[1] + " ist leer.";
				return true;
			}

			if (!stein.getSpieler().equals(this.current))
			{
				this.message = "Stein " + chars[0] + chars[1] + " gehoert nicht " + this.current + ".";
				return true;
			}
			
			if (!this.spielfeld.isLegalMove(stein, r2, c2))
			{
				this.message = "Stein " + chars[0] + chars[1] + " kann nicht auf Feld "  + chars[3] + chars[4] + " bewegt werden.";
				return true;
			}
			
			this.spielfeld.moveToken(stein, r2, c2);
			this.current = (this.current == this.white) ? this.black : this.white;
		}
		
		return true;
	}
}
