public abstract class IntStackTest
{
	public static void main(String[] args)
	{
		IntStack stack = null;
		int wert = 0;
		
		System.out.println("IntStack Test");
		stack = new IntStack(10);
		
		System.out.println("Stack mit 3 Werten belegen und ausgeben:");
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		stack.print();
		
		System.out.printf(".peek()=%d\n", stack.peek());
		
		System.out.printf(".pop()=%d\n", stack.pop());		
		System.out.printf(".pop()=%d\n", stack.pop());

		System.out.printf(".length()=%d\n", stack.length());
		System.out.printf(".isEmpty()=%b\n", stack.isEmpty());
	}
}
