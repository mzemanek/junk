// 2010-12-06
// package uebung1;

public class Uebung1
{
	public class Innen
	{
		private int value;
		
		public Innen(int value)
		{
			this.value = value;
		}
		
		public int quad()
		{
			return this.value * this.value;
		}
	}
	
	public static void main(String[] args)
	{
		Uebung1 subject = new Uebung1();
		
		subject.halb();
	}
	
	public void halb()
	{
		Innen innen = new Innen(5);
		System.out.println("quad=" + innen.quad());
	}
}
