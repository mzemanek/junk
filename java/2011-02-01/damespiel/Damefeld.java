// 2011-02-01
package damespiel;

public class Damefeld extends Spielfeld
{
	// Construction.
	//
	public Damefeld()
	{
		this.array = new Spielstein[8][8];
	}
	
	// Methods.
	//
	public boolean isFree(int row, int col)
	{
		if ((row > 0) && (row < 8) && (col > 0) && (col < 8))
		{
			return (null == this.array[row][col]);
		}
		
		return false;
	}
	
	public boolean legalMove(Spielstein s, int row, int col, boolean b)
	{
		if (this.isFree(row, col))
		{
			int dx = Math.abs(s.getRowPos() - row);
			int dy = Math.abs(s.getColPos() - col);
			
			// Einfacher Stein, nur diagonale Bewegung zulassen.
			if ((1 == dx) && (1 == dy))
			{
				// TODO: Bewegungsrichtung wird noch nicht berücksichtigt!
				return true;
			}
		}
		
		return false;
	}
	
	public void printWholeField()
	{
		final char[] fields = {'b', 'w'};
		
		System.out.println();
		
		for (int r = 0; r < 8; r++)
		{
			for (int c = 0; c < 8; c++)
			{
				int index = (0 != ((r * 8 + c + (0 == r % 2 ? 1: 0)) % 2)) ? 0 : 1;
				
				//System.out.print(index);		
				System.out.print(fields[index]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
}
