// 2010-11-08
// package Matrix;

import java.util.Scanner;

public final class Matrix
{
	private int[] data;
	private int m;
	private int n;
	private boolean square;
	private int value;
	
	public Matrix(boolean square)
	{
		if (square)
		{
			this.m = Matrix.readInt("Bitte Dimension eingeben: ");
			this.n = m;
		}
		else
		{
			this.m = Matrix.readInt("Bitte m eingeben: ");
			this.n = Matrix.readInt("Bitte n eingeben: ");
		}
		
		this.value = Matrix.readInt("Bitte Wert eingeben: ");
		this.square = square;
		
		this.reset();

		System.out.println();
	}

	public void print()
	{
		System.out.printf("%d X %d Matrix\n", this.m, this.n);
		for (int row = 0; row < this.m; row++)
		{
//			System.out.printf("%d", row + 1);
			for (int col = 0; col < this.n; col++)
			{
				System.out.printf("\t%d", this.data[row * this.n + col]);
			}
			
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void reset()
	{
		this.data = new int[this.m * this.n];
		for (int i = 0; i < this.data.length; i++)
		{
			this.data[i] = this.value;
		}
	}
	
	public void writeDiag(boolean main)
	{
		System.out.printf("%sdiagonale wird erzeugt.\n", (main) ? "Haupt" : "Neben");
		if (!this.square)
		{
			System.out.println("Matrix ist nicht quadratisch.");
			return;
		}
		
		if (main)
		{
			for (int i = 0; i < this.m; i++)
			{
				this.data[i * this.n + i] *= 2;
			}
		}
		else
		{
			for (int i = 0; i < this.m; i++)
			{
				this.data[i * this.n + this.n - i -1] *= 3;
			}
		}

		System.out.println();
	}
	
	private static int readInt(String message)
	{
		Scanner input = null;
		
		input = new Scanner(System.in);
		System.out.print(message);
		return input.nextInt();
	}
}


