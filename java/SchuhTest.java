public abstract class SchuhTest
{
	public static void main(String[] args)
	{
		Schuh s1 = new Schuh();
		Schuh s2 = new Schuh(44);
		Schuh s3 = new Schuh(42, "Panther");
		
		// Testfall 1.
		System.out.println("\nTestfall 1:");
		s1.setGroesse(42);
		s1.setHersteller("Mike");
		s1.setModellbezeichnung("Air Ultramatic");
		
		s1.print();
		
		// Testfall 2.
		System.out.println("\nTestfall 2:");
		s2.print();
		
		// Testfall 3.
		System.out.println("\nTestfall 3:");
		s3.print();
	}
}
