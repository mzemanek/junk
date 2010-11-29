// 2010-11-29
// package easy;

public abstract class EasyTest
{
	public static void main(String[] args)
	{
		EasyAccess access = null;
		EasySetter setter = null;
		EasyUsage usage = null;
		
		usage = new EasyUsage();
		setter = usage;
		access = usage;
		
		usage.setValue("Hallo Welt.");
		
		System.out.println(usage);
		System.out.println(setter);
		System.out.println(access);
		System.out.println();
		
		System.out.println("usage.print()");
		usage.print();
		System.out.println();
		
		System.out.println("access.print()");
		access.print();
		System.out.println();
	}
}
