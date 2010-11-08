// 2010-11-08
// package Matrix;

public abstract class MatrixTest
{
	public static void main(String[] args)
	{
		Matrix m = null;
		
		System.out.println("Matrix");
		
		System.out.println("Quadratisch:");
		m = new Matrix(true);
		m.print();
		m.writeDiag(true);
		m.print();
		m.reset();
		m.writeDiag(false);
		m.print();
		
		System.out.println("Nicht quadratisch:");
		m = new Matrix(false);
		m.print();
		m.writeDiag(true);
		m.print();
		m.reset();
		m.writeDiag(false);
		m.print();
	}
}
