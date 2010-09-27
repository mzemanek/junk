public abstract class IntQueueTest
{
	public static void main(String[] args)
	{
		IntQueue subject;
		
		System.out.println("IntQueueTest");
		subject = new IntQueue(5);
		
		System.out.printf("getElementCount()=%d\n", subject.getElementCount());
		
		subject.addElement(33);
		subject.addElement(42);
		
		subject.print();
		
		System.out.printf("getElementCount()=%d\n", subject.getElementCount());
		
		System.out.printf("getElement()=%d\n", subject.getElement());
		System.out.printf("getElement()=%d\n", subject.getElement());
	}
}
