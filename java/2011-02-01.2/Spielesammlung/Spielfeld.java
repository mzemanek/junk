// 2011-02-01
package Spielesammlung;

public interface Spielfeld
{
	Spielstein getToken(int row, int col);
	boolean isFree(int row, int col);
	boolean isLegalMove(Spielstein s, int row, int col);
	boolean moveToken(Spielstein s, int row, int col);
	void printWholeField();
}
