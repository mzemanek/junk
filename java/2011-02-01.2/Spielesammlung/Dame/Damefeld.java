// 2011-02-01
package Spielesammlung.Dame;

import Spielesammlung.*;

public class Damefeld implements Spielfeld
{
	private static final String[] Colors = {" ", "X"};
	
	private Spielstein[][] feld = new Spielstein[8][8]; // = null;
	
	public Spielstein getToken(int row, int col)
	{
		if (this.isIngame(row, col))
		{		
			return this.feld[row][col];
		}
		
		return null;
	}
	
	public boolean isFree(int row, int col)
	{
		if (this.isIngame(row, col))
		{
			return (null == this.feld[row][col]);
		}
		
		return false;
	}
	
	public boolean isIngame(int row, int col)
	{
		return ((-1 < row) && (8 > row) && (-1 < col) && (8 > col));
	}
	
	public boolean isLegalMove(Spielstein s, int row, int col)
	{
		int dr = 0;
		int dc = 0;
		
		if (!this.isIngame(row, col))
		{
			return false;
		}
		
		if (!this.isFree(row, col))
		{
			return false;
		}
		
		dr = row - s.getRow();
		dc = Math.abs(col - s.getCol());
		
		switch (((Damestein)s).getDirection())
		{
			case /*Damestein.Direction.*/BOTTOMUP:
				System.out.println("Up");
				if ((1 == dc) && (-1 == dr))
				{
					return true;
				}
				
				break;
			
			case /*Damestein.Direction.*/TOPDOWN:
				System.out.println("down");
				if ((1 == dc) && (1 == dr))
				{
					return true;
				}
				
				break;
				
			default:
				return false;
		}
		
		return false;
	}
	
	public boolean moveToken(Spielstein s, int row, int col)
	{	
		// Clear previous position.
		if (this.isIngame(s.getRow(), s.getCol()))
		{
			this.feld[s.getRow()][s.getCol()] = null;
		}
		
		this.feld[row][col] = s;
		s.setRow(row);
		s.setCol(col);
		
		return true;
	}
	
	public void printWholeField()
	{
		System.out.println();
		
		for (int r = 0; r < 8; r++)
		{
			// Column names.
			if (0 == r)
			{
				System.out.print("  ");
				
				for (int i = 0; i < 8; i++)
				{
					System.out.print((i + 1));
				}
				
				System.out.println();
				System.out.println("  --------");
			}
			
			for (int c = 0; c < 8; c++)
			{
				Damestein token = null;
				
				// Row name.
				if (0 == c)
				{
					System.out.print((char)(65 + r) + "|");
				}
				
				token = (Damestein)this.getToken(r, c);
				if (null == token)
				{
					int index = 0;
					
					// Render blank field.
					index = (0 == ((r * 8) + c + ((0 == r % 2) ? 0 : 1)) % 2) ? 0 : 1;
					System.out.print(Colors[index]);
					
				}
				else
				{
					// TODO: Render token.
					System.out.print(token.getFarbe());
				}
			}
			
			System.out.println("|");
		}
		
		System.out.println();
	}
}
