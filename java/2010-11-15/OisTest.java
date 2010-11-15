// 2010-11-15
// package Ois;

public abstract class OisTest
{
	public static void main(String[] args)
	{
		Ois[] feld = null;
		
		feld = new Ois[2];
		feld[0] = new Vater();
		feld[1] = new Sohn();
		
		for (Ois item : feld)
		{
			item.print();
			System.out.println();
		}
	}
}
