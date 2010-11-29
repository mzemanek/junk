// 2010-11-29
// package collection;

public abstract class simpleVectorTest
{
	public static void main(String[] args)
	{
		String a = "Hallo";
		String b = "auf";
		String c = "der";
		String d = "Welt";
		
		simpleVector vec = new simpleVector();
		
		vec.add(a);
		vec.add(b);
		vec.add(c);
		vec.add(d);
		
		Object x = null;
		
		while (null != (x = vec.next()))
		{
			System.out.print(x + " ");
		}
		
		System.out.println();
		
		vec.remove(c);
		vec.reset();
		
		while (null != (x = vec.next()))
		{
			System.out.print(x + " ");
		}
		
		System.out.println();
	}
}
