public abstract class SchuhTest
{
	public static void main(String[] args)
	{
		Schuh s = new Schuh();
		
		s.setGroesse(42);
		s.setHersteller("Mike");
		s.setModellbezeichnung("Air Ultramatic");
		
		s.print();
	}
}
