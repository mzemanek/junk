// 2010-12-06
// package anonymbasis;

public abstract class AnonymBasisTest
{
	public static void main(String[] args)
	{
		AnonymBasis subject1 = null;
		AnonymBasis subject2 = null;
		
		subject1 = new AnonymBasis()
		{
			public int f(int a, int b)
			{
				return a + b;
			}
		};
		
		System.out.println("subject1.drucke()");
		subject1.drucke();
		
		subject2 = new AnonymBasis()
		{
			public int f(int a, int b)
			{
				return a - b;
			}
		};
		
		System.out.println("subject2.drucke()");
		subject2.drucke();
	}
}
