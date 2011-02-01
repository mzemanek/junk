// 2011-02-01
package damespiel;

public abstract class Spielfeld
{
	protected Spielstein array[][] = null;
	
	// Methods.
	//
	public abstract boolean isFree(int r, int c);
	
	public abstract boolean legalMove(Spielstein s, int row, int col, boolean b);
	
	public void moveToken(Spielstein s, int row, int col)
	{
		if (this.isFree(row, col) && this.legalMove(s, row, col, false))
		{
			this.array[s.getRowPos()][s.getColPos()] = null;
			this.array[row][col] = s;
			s.setRowPos(row);
			s.setColPos(col);
		}
		
		this.printWholeField();
	}
	
	public Spielstein getSpielstein(int row, int col)
	{
		if (!this.isFree(row, col))
		{
			return this.array[row][col];
		}
		
		return null;
	}
	
	public abstract void printWholeField();
}
