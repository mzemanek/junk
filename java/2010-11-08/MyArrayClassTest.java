// 2010-11-08
// package MyArrayClass;

public abstract class MyArrayClassTest
{
	public static void main(String[] args)
	{
		MyArrayClass subject;
		
		System.out.println("MyArrayClass");
		System.out.println();
		
		subject = new MyArrayClass();
		System.out.println(subject.addInt(10, 5));
		System.out.println(subject.addInt(10, 7));
		System.out.println(subject.addInt(12, 7));
		subject.print();
		
		System.out.println();
		System.out.println("Subjekt wird freigegeben.");
		subject = null;
		
		System.out.println("Garbage Collection anwerfen.");
		Runtime r = Runtime.getRuntime();
		r.gc();
	}
}
